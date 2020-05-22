for (int time = 0; time <= t.time; time += 10) {
    try {
        Thread.sleep(10);
    } catch(InterruptedException exc) {
        System.out.println("End of thread.");
        return;
    }
}