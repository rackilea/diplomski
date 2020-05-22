for (Future<MachineMetrics> future : machineFutureList) {
    try {
        metricsList.add(future.get());
    } catch (InterruptedException | ExecutionException ex) {
        // log exception here
    }
}