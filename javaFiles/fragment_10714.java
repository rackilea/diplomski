int threads = Runtime.getRuntime().availableProcessors();
ExecutorServer es = Executors.newFixedThreadPool(threads);

List<Future<String>> results = new ArrayList<>();
for (int i = 0; i < tasks; i++)
     results.add(es.submit(new Callable<String>() {
          public String call() {
              // task which returns a String
          }
     });
try (PrintWriter fw = new PrintWriter("output.txt")) {
    for (Future f : results)
        fw.println(f.get());
}