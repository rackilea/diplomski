public synchronized void printX() {
    try {
        wait();   <--- since t2 has finished, t1 will get stuck here!
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println("XXX");
}