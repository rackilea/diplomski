public interface TableEntry {
    public List<String> getColumnValues();
}

public class WorkerTableEntry implements TableEntry {

    private final Worker worker;

    public WorkerEntry(Worker worker) {
        this.worker = worker;
    }

    @Override
    public List<String> getColumnValues() {
        List<String> columns = new ArrayList<>();
        columns.add(worker.getFirstName());
        columns.add(String.valueOf(worker.getAge()));
        columns.add(worker.getJob());
        return columns;
    }
}