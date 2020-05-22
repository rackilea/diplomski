abstract public class Table { // no generics necessary
    // subclasses must override this
    abstract protected Row newRow ();
    // the base class can use newRow() to let the subclass determine the type
    public List<Row> fetchAll () {
        // in the while loop to add each row to the array:
        Row row = newRow();
    }
}