private final Object dirtyLock = new Object();

Thread refreshThread = new Thread(new Runnable() {
    public void run() {
       while(true){
           synchronized(dirtyLock){
               dirtyLock.wait(); // Send this thread to sleep until dirtyLock is unlocked                       
           }
           TasksManager.refreshTasks(true);
           panel.repaint();
        }
    });
refreshThread.start(); 

// When your TaskManager becomes dirty, do the following
public void changeToDirty(){
    TaskManager.setDirty(true);
    synchronized(dirtyLock){
           dirtyLock.notifyAll(); 
           // this will release the refresh thread which will repaint and then go to sleep
     }
}