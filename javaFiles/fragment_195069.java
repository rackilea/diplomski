final Thread thread = new Thread(
        new Runnable(){
            public void run(){
                while(condition){
                    .....
                }
                //update gui
            }
        }
);
thread.start();