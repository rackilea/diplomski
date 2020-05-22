void waitForUpdates() {
    synchronized (theData) {
       while (notCancelled) {
          theData.wait();  // wait for notification
          handleUpdate(theData);
       }
    }        
}