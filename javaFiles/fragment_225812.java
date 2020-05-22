Thread t1 = new Thread(() -> {
    synchronized (resource1) {  
        System.out.println("Thread 1: locked resource 1");  

        try { Thread.sleep(100);} catch (Exception e) {}  

        synchronized (resource2) {  
            System.out.println("Thread 1: locked resource 2");  
        }  
    }  
});