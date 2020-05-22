private class TimerPopTask implements Runnable  {
    //volatile for thread-safety
    private volatile boolean isActive = true;  
    public void run ()   {  
        if (isActive){
            TimerPopped();
        }
    }  
    public void deactivate(){
        isActive = false;
    }
}