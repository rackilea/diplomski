private final class MyTask implements Runnable {

    public void run() {
        try{
            for(int j=0; j<100000000; j++) {
                for(int i=1; i<1000000000; i++){
                    if(Thread.interrupted()){ //Don't use Thread.interrupt()!
                        Log.debug("Thread was interrupted for" + cache);
                        return; //Stop doing what you are doing and terminate.
                    }
                    Math.asin(0.1565365897770/i);
                    Math.tan(0.4567894289/i);
                }
            }                            
        }catch(Throwable e){//if exception is uncaught, the scheduler may not run again 
            ...
        }
    }
}