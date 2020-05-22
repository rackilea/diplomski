class MainThread {
    private void MainThread() {
        SomeType obj = new SomeType("DATA Needed");

        SecondThread second = new SecondThread(obj);
        second.start();
    }
}

class SecondThread extends Thread {
    SomeType obj;

    public SecondThread(SomeType obj) {
       this.obj = obj;
    }
    public void run() {
      // can call methods on obj here
    }
}