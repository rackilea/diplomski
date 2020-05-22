Set<Callable<String>> tasks = new HashSet<>();
for (String word : args) {
    tasks.add(new WordLengthCallable(word, waitArr[i++]));
}
List<Future<String>> futures = Executors.newFixedThreadPool(3)
        .invokeAll(tasks, 2000, TimeUnit.MILLISECONDS);