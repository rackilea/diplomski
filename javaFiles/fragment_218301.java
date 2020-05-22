// Using specific locks
Object inputLock = new Object();
Object outputLock = new Object();

private void someInputRelatedWork() {
    synchronized(inputLock) { 
        ... 
    } 
}
private void someOutputRelatedWork() {
    synchronized(outputLock) { 
        ... 
    }
}