Timer particularTimer = new Timer();
    final Timer certainTimer = new Timer();//u can declare a final timer for certain process
    particularTimer.schedule(new TimerTask() {
        public void run(){
            System.out.println("run particularTimer");
            certainTimer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("run certainTimer");
                }
            }, 5000);// it's my start time in milliseconds

        }
    }, 5000);

    //eg
    Thread.sleep(6000);
    particularTimer.cancel();//when u cancel the particularTimer,and u can cancel the certainTimer too.
    certainTimer.cancel();