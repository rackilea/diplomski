class ThreadEx4 extends Thread{
    private int i;
    public ThreadEx4(int i) {
        this.i=i;
    }
    public void run() {
        ++i;
        System.out.println("changed the value to "+i);
    }
}