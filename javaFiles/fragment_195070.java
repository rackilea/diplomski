final Thread thread = new Thread(
        () -> {
            while(condition){
                .....
            }
            //update gui
        }
);
thread.start();