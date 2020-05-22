// Open stream of rows 
val csvLines: Stream[Array[String]] = <open stream from CSV parser>
// Define a parent to hold the vectors
val parent = MapVector.empty("parent", allocator)
// Create a new writer. VarCharWriterImpl would probably do as well?
val writer = new ComplexWriterImpl("root", parent)

// Initialise a writer for each column, using the header as the name
val rootWriter = writer.rootAsMap()
val writers = csvLines.head.map(colName => 
                                  rootWriter.varChar(colName))

Stream.from(0)
  .zip(csvLines.tail) // Zip the rows with their index
  .foreach( rowTup => { // Iterate on each (index, row) tuple
    val (idx, row) = rowTup
      Range(0, row.size) // Iterate on each field of the row
        .foreach(column =>
          Option(row(column)) // row(column) may be null,
            .foreach(str =>   // use the option as a null check
              write(writers(column), idx, allocator, str)
            )
      )
  }
)

toFile(parent.getChild("root"), "csv.arrow") // Save everything to a file