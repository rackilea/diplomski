Task<Map<String, String>> parseDataTask = new Task<Map<String, String>>() {

    @Override
    public Map<String, String> call() {
        SomeParser someParser = new FirstParserImpl();
        return someParser.parseSomething();
    }
};

parseDataTask.setOnSucceeded(e -> {
    Map<String,String> parseResults = parseDataTask.getValue();
    // update UI here with parseResults, e.g:
    loadTableView(parseResults);
});

Thread t = new Thread(parseDataTask);
t.setDaemon(true);
t.start();