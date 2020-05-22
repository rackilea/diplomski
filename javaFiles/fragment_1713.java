class AddingThread extends Thread {

@Override
public void run() {
    System.out.println("Adding thread started");
    int ctr = 0;
    while (true) {
        synchronized (HashSetTest.obj) {
            RemovalThread.originalBigSet.add(ctr);
        }
        ctr++;
    }
}