List<Thread> threads = new ArrayList<>();
for (int i = 0; i < eventsSize; i++) {
    if (...) {
        Thread t = new Thread()...;
        t.start(); // Don't call join() after start() here
        threads.add(t);
    } else {
       ...
    }
}

// Instead call join here:

for (Thread t : threads) {
   t.join(); // Need try catch
}
.. bla bla..