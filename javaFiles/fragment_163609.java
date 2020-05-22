public class MyThread extends Thread{
        volatile boolean isRunning = true;//make sure use volatile keyword
        @Override
        public void run() {

            while(isRunning) {

                Log.d(TAG,"Inside Thread");

            }
        }
        public void setRunning(boolean running){
            this.isRunning = running;
        }
    };