interface RecordFactory {
    Record create();
}

class CustomerFactory implements RecordFactory {
    Record create() {
        return new Customer();
    }
}

public List<Record> getAllRecords(RecordFactory factory) {
    ...
    for(...) {
        ...
        Record record = factory.create();
        ...
    }
    ...
}