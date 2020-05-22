class SystemIPChanger implements Runnable {
      Collection<WorkerThread> pool;

      public void changeIP() {
          pauseAllThreads();
          changeIP();
          resumeThreads();
      }

      void pauseAllThreads() {
          CountDownLatch latch = new CountDownLatch(pool.size());
          for (WorkerThread worker : pool) {
              worker.setPause(latch);
          }
          latch.await();          
      }

      void resumeThreads() {
          for (WorkerThread worker : pool) {
              worker.setPause(null);
          }

      }
  }

  class WorkerThread implements Runnable {
    private CountDownLatch pause;

    public void run() {
        while (...) {
            pause();
            doRealWork(); 
        }
    }


    synchronized void pause() {
        CountdownLatch latch = pause;
        if (latch!=null) {
           latch.countDown();
           while (pause==latch) {
               wait();
           }
        }
    }

    public synchronized void setPause(CountDownLatch latch) {
        this.pause = latch;
        notifyAll();
    }
  }