List<Future> futures = new ArrayList<Future>();
for (int i=0; i<n; i++) {
    futures.add(e.submit(new aRunnable()));
}
// now go back and wait for all of those tasks to finish
for (Future future : futures) {
    future.get();
}
// now you can go forward and submit other tasks to the thread-pool