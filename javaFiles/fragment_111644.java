Thread t3 = new Thread(() -> { 
    System.out.println("Thread 3 terminating..."); 
});

Thread t2 = new Thread(() -> {
    try { t3.join(); } catch(InterruptedException e) {}; 
    System.out.println("Thread 2 terminating..."); 
});

Thread t1 = new Thread(() -> {
    try { t2.join(); } catch(InterruptedException e) {}; 
    System.out.println("Thread 1 terminating..."); 
});

t1.start();
t2.start(); 
t3.start();