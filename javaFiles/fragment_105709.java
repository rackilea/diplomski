public class WriterThread implements Runnable {

    private volatile boolean stopped = false;

    public synchronized void stop() {
        this.stopped = true;
    }

    public void run(){
            textArea.setText("");

            for (int i=0; i<10; i++) {
                    if (this.stopped) {
                            break;
                    }

                    int result= 0;
                    System.out.println(result+"\n");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }
            }
        }
    }
}