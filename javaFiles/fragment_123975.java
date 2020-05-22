synchronized (dj) {
    while (true) {
        try {
            dj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}