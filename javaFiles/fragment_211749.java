// CREAT COUNT DOWN LATCH
        CountDownLatch latch = new CountDownLatch(1);

   //create two threads:
        Thread thread1 = new Thread(() -> {
          try {
            //will wait until you call countDown
            latch.await();
           botMovement(theBotAL.get(0))

          } catch(InterruptedException e) {
            e.printStackTrace();
          }
        });

        Thread thread2 = new Thread(() -> {
          try {
            //will wait until you call countDown
            latch.await();
           botMovement(theBotAL.get(1))
          } catch(InterruptedException e) {
            e.printStackTrace();
          }
        });

    //start the threads
        thread1.start();
        thread2.start();
    //threads are waiting

    //decrease the count, and they will be notify to call the botMovement method
     latch.countDown();