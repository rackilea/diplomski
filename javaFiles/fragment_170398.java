class ThreadSafeMutableThreadParam implements Runnable {
    private int c;

    public ThreadSafeMutableThreadParam( int a, int b ) {
        c = a + b;
    }

    public synchronized void setC( int c ) {
        this.c = c;
    }

    public synchronized int getC() {
        return c;
    }

    public void run() {
        System.out.println( getC() );
    }
}