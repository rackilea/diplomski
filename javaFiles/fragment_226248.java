synchronized (this) {
    fulllogin(lockall, locknormalusertest);
    boolean viewed = false;
    while (viewed == false) {
        wait();
    }
    System.out.println("notify test");
}

// ...

synchronized (this) {
    boolean viewed = true;
    notifyAll();
    Thread.sleep(15000);
}