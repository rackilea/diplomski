public class Body {
    private List<Record> records;

    public Body() {
        records = new ArrayList<Record>();
    }

    public void addRecod(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}