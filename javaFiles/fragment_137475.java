Thread t1 = new Thread(()->{
    while(true){
        System.out.println("daemon1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {}
    }
});
t1.setDaemon(true);

Thread t2 = new Thread(()->{
    while(true){
        System.out.println("daemon2");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {}
    }
});
t2.setDaemon(true);

t1.start();
t2.start();

try {
    TimeUnit.SECONDS.sleep(5);
} catch (Exception e) {}
System.out.println("main thread stopped");