try (InputStream in = batchFile[0].getInputStream()) {
    FlatFileItemReader<Customer> reader = new FlatFileItemReader<>();
    reader.setResource(new InputStreamResource(in));
    reader.open(new ExecutionContext());
    // more code here
}