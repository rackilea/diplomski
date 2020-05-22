final Object a = new Object();
    final Object b = new Object();
    CountDownLatch latch = new CountDownLatch(2);

    new Thread(()->{
        System.out.println(Thread.currentThread().getId() + " running");
        synchronized(a){    
            try{
                latch.countDown();
                latch.await();
            } catch(InterruptedException e){
                return;
            }
            synchronized(b){
                System.out.println("no deadlock");  
            }
        }   

    }).start();


    new Thread(()->{
        System.out.println(Thread.currentThread().getId() + " running");
        synchronized(b){
            try{
                latch.countDown();
                latch.await();
            } catch(InterruptedException e){
                return;
            }
            synchronized(a){
                System.out.println("no deadlock");  
            }
        }   

    }).start();