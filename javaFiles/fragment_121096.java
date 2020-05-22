public String train(String lang, String entity, InputStreamFactory inputStream, FileOutputStream modelStream) {

    // ....
    try {
        ObjectStream<String> lineStream = new PlainTextByLineStream(trainingDataInputStreamFactory(Arrays.asList(
                new File("trainingdata1.txt"),
                new File("trainingdata2.txt"),
                new File("trainingdata3.txt")
        )), charset);

        // ...
    } 

    // ...
}

private InputStreamFactory trainingDataInputStreamFactory(List<File> trainingFiles) {
    return new InputStreamFactory() {
        @Override
        public InputStream createInputStream() throws IOException {
            List<InputStream> inputStreams = trainingFiles.stream()
                    .map(f -> {
                        try {
                            return new FileInputStream(f);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return new SequenceInputStream(new Vector<>(inputStreams).elements());
        }
    };
}