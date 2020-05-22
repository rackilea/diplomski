abstract public class Table<RowClass extends Row>{
    private final Class<RowClass> rowClass; // holds the Class of each row
    public Table (Class<RowClass> rowClass) {
        this.rowClass = rowClass;
    }
    public List<RowClass> fetchAll() {
        //Fetch the stuff here
        //In the while class to add each row to the array
        RowClass row = rowClass.newInstance();
    }
}