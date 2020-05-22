private static class player2 extends Thread {
          public void run() {
             synchronized (enemy1) {
                System.out.println("...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("");
                synchronized (enemy2) {
                   System.out.println("");
                }
             }