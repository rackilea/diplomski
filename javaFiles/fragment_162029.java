class SomeSpecialProcessing {
    private Writer writer;

    public SomeSpecialProcessing(Writer writer) {
        this.writer = writer;
    }

    public String doSomeProcessing() {
        // some special calculation 
        persist(somethingImportant);
        // some special processing
        return importantResult;
    }

    private void persist(String somethingImportant) {
        this.writer.write(str);
    }
}