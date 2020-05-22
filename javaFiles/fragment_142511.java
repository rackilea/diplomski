class InputInterruptionExample {

    private UserInputThread userInputRunnable;
    private Thread userInputThread;
    private Thread interrupterThread;

    InputInterruptionExample() {
        this.userInputRunnable = new UserInputThread();
        this.userInputThread = new Thread(userInputRunnable);
        this.interrupterThread = new Thread(new InterrupterThread());
    }

    void startThreads() {
        this.userInputThread.start();
        this.interrupterThread.start();
    }
    private class UserInputThread implements Runnable {
        private InputStreamReader isr;
        private BufferedReader br;

        UserInputThread() {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
        }

        public void run() {
            try {
                System.out.println("enter your name: ");
                try{
                    String userInput = br.readLine();
                } catch(NullPointerException e) {}
            } catch (IOException e) {
                System.out.println("Oops..somethign went wrong.");
                System.exit(1);
            }
        }
        public void closeBufferdReader() {
            try {
                System.in.close();
            } catch (IOException e) {
                System.out.println("Oops..somethign went wrong in closeBufferdReader() method");
                System.exit(1);
            }
        }
    }
    private class InterrupterThread implements Runnable {
        public void run() {
            try {
                sleep(1000);
                userInputRunnable.closeBufferdReader();                 
                userInputThread.interrupt();
                userInputThread.join();
                System.out.println("Successfully interrupted");
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args) {
        InputInterruptionExample exampleApp = new InputInterruptionExample();
        exampleApp.startThreads();
    }
}