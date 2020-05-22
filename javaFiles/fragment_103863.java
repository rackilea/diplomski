while (time == t.time) {
    try {
        Thread.sleep(10);
    } catch(InterruptedException exc) {
        System.out.println("End of thread.");
        return;
    }
    time = time + 100;
}