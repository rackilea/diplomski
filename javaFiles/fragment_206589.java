List<Worker> workers = ...

List<TableEntry> entries = new ArrayList<>();
for (Worker worker: workers) {
    entries.add(new WorkerTableEntry(worker));
}

TableBuilder builder = new TableBulder();
builder.buildTable(entries);