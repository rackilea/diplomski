public class Recorder {
    static Long RECORD_TIME = 100000L; //or whatever time you use   

    public static void main(String[] args) {
        final Main REGISTRAZIONE = new Main();

        Thread TIME = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                REGISTRAZIONE.finish();
            }
        });
        TIME.start();

        myThread finisher = new myThread(TIME);
        finisher.start();
        REGISTRAZIONE.start();
    }
}

class myThread extends Thread implements Runnable {
    private Thread TIME;

    public myThread(Thread TIME) {
        this.TIME = TIME;
    }

    public void run() {
        while (!silence()) {
            // do nothing
        }
        TIME.interrupt();
    }

    private boolean silence() {
        //record and calculate the dB volume and compare to some level
        return true;
    }
}