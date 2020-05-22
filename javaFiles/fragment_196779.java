void test1() {
    synchronized(this) {
        while(1 == 1) {
            System.out.println(Thread.currentThread().getName() + " test1!");
        }
    }
}