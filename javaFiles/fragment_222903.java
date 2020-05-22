public class Data {
    private Map<String, User> record;

    public Map<String, User> getRecord() { return record; }

    public void setRecord(Map<String, User> record) { this.record = record; }

    @Override
    public String toString() {
        return "Data{" +
                "record=" + record +
                '}';
    }
}