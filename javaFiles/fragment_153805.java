final int time = second * 1000;
    Thread sound = new Thread(new Runnable() {

        @Override
        public void run() {

            start(view);
            try{
                Thread.sleep(time);
            }catch(Exception e){}
            stop();
        }
    });