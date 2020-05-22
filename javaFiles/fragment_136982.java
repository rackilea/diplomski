List<Worker> workers = new ArrayList<Worker>();
...
workers.add(new PrintWorker());
workers.add(new AnotherPrintWorker());
...
for (Worker worker : workers) {
    worker.work();
}