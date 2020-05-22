class FooService {
    private void insertRecord(Foo foo) {
        // insert one record to DB
    }

    public void insertOne(Foo foo) {
        insertRecord(foo);
    }

    public void insertMany(List<Foo> foos) {
        // I want to stop logging here
        MDC.put("tracing", "off");
        for (Foo foo: foos) {
            insertRecord(foo);
        }
        // I want to resume logging here
        MDC.remove("tracing");
    }
}