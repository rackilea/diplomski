public class Storage {
    List<Record> recordList;
    public Storage() {
        this.recordList = new ArrayList<Record>();
    }
    public void addRecord(Record record) {
        recordList.add(record);
    }
}

// previous code ...
Storage storage = new Storage();
try {
    // ...
    Record record = new Record(j, Integer.parseInt(ContentCount), RowContent));
    storage.add(record);
} catch (...) {
    // ...
}