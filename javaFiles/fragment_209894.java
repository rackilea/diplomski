class MyThread extends Thread {
    private boolean keepRunning = true;
    private String currentStatus = "Not Running";
    public void run() {
        currentStatus = "Executing"
        while(keepRunning)
        {
           try {
               someTask()
               currentStatus = "Done";
           } catch (Exception e) {
               currentStatus = "task failed";
               keepRunning = false;
           }
        }
    }

    public stopThread() {
       keepRunning = false;
    }
}