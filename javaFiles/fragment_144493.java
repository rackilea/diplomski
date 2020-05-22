ExecutorService es = Executors.newFixedThreadPool(4);
List<String> upperLines = lines.stream()
    .map(String::toUpperCase)
    .peek(line -> es.execute(() -> System.out.println(line)))
    .collect(Collectors.toList());
es.shutdown();