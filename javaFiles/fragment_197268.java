public class parallelUpdate {
        public static void main(String[] args) {
            Ob ob = new Ob();
            new Thread(ob).start();
            new Thread(ob).start();

        }
    }


    class Ob implements Runnable {
        static int cnt = 0;
        private synchronized void inc() {
              for (int i = 0; i < 5; i++) {
                  System.out.println(Thread.currentThread());
                  cnt++;
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              } 
        }
        @Override
        public void run() {
          inc();
        }
    }