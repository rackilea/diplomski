//Create collection
List<String> resultList = new ArrayList<>();

ExecutorService executor = Executors.newFixedThreadPool(count);

Callable<List<String>>[] tasks = new Callable[10];
for (int i = 0; i < tasks.length; i++) {
    tasks[i] = new MyThread();
}

List<Future<List<String>>> futures = executor.invokeAll(Arrays.asList(tasks));
executor.shutdown();

for (Future<List<String>> future : futures) {
    // combine results
    resultList.addAll(future.get());
}

System.out.println(resultList); //Show collection