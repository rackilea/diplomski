public void processRefreshEvent(ManagerEvent event){
        //processing event
        //...
        //I'm done
    synchronized(this) {
        notify(); // you are basically notifying any thread who has blocked
                  // on this monitor - in our case, the instance of this object
    }
}


public synchronized void refresh() throws Exception {
        isRefreshing = true;    
        try {
                    manager.send(new refresh());
        } catch (ManagerException e) {
                isRefreshing = false;
        }

        try {
          synchronized(this) {
                wait(5000); // wait will give up the monitor
          }
        } catch (InterruptedException e) {
        } finally{
                isRefreshing = false;
        }
}