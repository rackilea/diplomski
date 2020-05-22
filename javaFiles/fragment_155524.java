public class MyCSVSearch implements CSVSearch {

    // Some constructor that would accept the file/text to parse and parse it with a good logic

    public CSVRecord find(String key) {

        MyCSVRecord record = new MyCSVRecord(); // Note this is your class that implements CSVRecord.

        // The logic to store the record details into the record object

        return record; // As said initially, it is ok to return an object of MyCSVRecord as it implements CSVRecord.
    }

}

public class MyCSVRecord implements CSVRecord {

    // May be you need some properties to store the data (perhaps a hash map).

    public String getField(String name) {
        // Return the relevant field from the properties
    }

}