for (Runnable task:tasks) {
    futures.add(executorService.submit(task));
}

for (Future<Void> result:futures) {
    result.get();
}