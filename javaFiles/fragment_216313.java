void updateData() {
    synchronized (theData) {
       theData.doSomeUpdate();
       theData.notifyAll(); // tell other threads of a change
    }
}