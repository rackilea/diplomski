Callable<Object> task = new Callable<Object>() {
           public Object call() {
              int i=1;
              while(i<100)
              {
                  System.out.println("i: "+ i++);
                  try {
                      if (Thread.currentThread().isInterrupted()) {
                          break; //breaking from the while loop
                      }
                      TimeUnit.SECONDS.sleep(1);
                  } catch(InterruptedException e) {
                      break; //breaking from the while loop
                  } catch(Exception e)
                  {
                  }
              }
              return null;
           }
        };