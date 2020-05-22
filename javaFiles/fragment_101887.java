// just print the results
static class PrintResultsFn extends DoFn<List<String>, Void> {
    @ProcessElement
    public void processElement(@Element List<String> words) {
        Log.info(Arrays.toString(words.toArray()));
    }
}