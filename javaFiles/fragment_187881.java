while(!Thread.currentThread().isInterrupted()){
    try{        
        Thread.sleep(10);
    }
    catch(InterruptedException e){
        Thread.currentThread().interrupt();
        break; //optional, since the while loop conditional should detect the interrupted state
    }
    catch(Exception e){
        e.printStackTrace();
    }