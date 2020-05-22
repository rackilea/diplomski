public FlatFileItemReader<MyObject> itemReader(
        @Value("file:#{jobParameters['directory']}") final String resourceDir,
        final DefaultLineMapper<MyObject> lineMapper) {

        File[] files=new File(resourceDir).listFiles(); // you can try giving FileNameFilter for .csv
        File csvFile=files[0]; // do null check and isempty
        // create Resource
        Resource resource = new FileSystemResource(csvFile);
    final FlatFileItemReader<MyObject> reader = new FlatFileItemReader<>();

    reader.setResource(resource);
    reader.setLinesToSkip(1);
    reader.setLineMapper(lineMapper);

    return reader;
}