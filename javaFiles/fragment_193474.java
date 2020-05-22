private void printId(){
    handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                System.out.print(someID); // works on 1st time but not any other future runs of the 1k interval
                printId();
            }
        }, 1000);
}