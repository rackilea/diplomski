new java.util.Timer().schedule( 
    new java.util.TimerTask() {
        @Override
        public void run() {
            for (int j = 0; j < threads.length; j++) {
                if(threads[j].getStatusCode().equals(OK)) {
                    //threads[j]'s jvm is up
                } else {
                    //threads[j]'s jvm is down
                }
            }
        }
    }, 
    5 * 60 * 1000
);