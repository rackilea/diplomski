List<Future<Integer>> futures = filesInPath.stream()
    .map(<create your Callable>)
    .map(executorService::submit)
    .collect(toList());

for (Future future : futures)
    totalWordCount += future.get();
}