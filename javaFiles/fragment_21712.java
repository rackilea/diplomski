Timer timer = new Timer("MyTimerName") 

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            //will print timer name 
        System.out.println("Timer Name: "
                        + Thread.currentThread().getName());
            //...

        }
    }