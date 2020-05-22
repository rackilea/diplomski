try {
        Timer timer = new Timer();

         long lastTimestamp = System.currentTimeMillis() / 1000;
        // WHEN DEBUGGING IT JUMPS FROM THIS LINE

        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("WWWWWWW");
                }
            }, 0, 1000);    
    }
    catch(Exception x){

    }
}