new Thread(new Runnable() {
    public void run() {
        long x = 0;
        for (long y = 0; y < Long.MAX_VALUE; y++) {
            x += y;
        }
        System.out.println("it will never get here of course: " + x);
    }
}, "Running-Thread").start();