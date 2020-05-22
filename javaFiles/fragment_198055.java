private final VersionValue versionValue = new VersionValue();

public void setValue(int value) {
    synchronized (monitor) {
       versionValue.value = value;
       versionValue.version++;
       monitor.notifyAll();
    }
}

 private class ValueWatcher {
     private long localVersion = 0;
     public int waitForValue() {
         synchronized (monitor) {
             while (true) {
                 if (localVersion < versionValue.version) {
                     // NOTE: the value might have been set twice here
                     localVersion = versionValue.version;
                     return versionValue.value;
                 }
                 monitor.wait();
             }
         }
     }
}

private static class VersionValue {
    int value;
    long version;
}