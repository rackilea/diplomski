private static class ThreadRunnable implements Runnable {
    final String fileName;
    final int[] loopBoundaries;
    public ThreadRunnable(String fn, int[] lb) {
        fileName = fn;
        loopBoundaries = lb;
    }
    @Override
    public void run() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(fileName);
            CrucibleOptimizer co = new CrucibleOptimizer();
            opt(co, pw, loop4boundries[0], loop4boundries[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}