try {
    for (Thread t: threadsIWaitOn)
        t.join();
} catch (InterruptedException iex) {
     /* ... handle error ... 
}