private static final String CSV = "firstName,lastName\nJohn,Dunbar\nBob,Down";

@Test
public final void testCollector() throws IOException {
    ICsvListReader reader = new CsvListReader(new StringReader(CSV), 
        CsvPreference.STANDARD_PREFERENCE);
    reader.getHeader(true); // skip header

    // Collector processor 'collects' values from a column
    List<Object> firstNames = new ArrayList<Object>();
    CellProcessor[] processors = {new Collector(firstNames), null};

    while(reader.read(processors) != null){
        // just keep reading - Collector will collect the values
    }

    // prints: [John, Bob]
    System.out.println(firstNames);
}