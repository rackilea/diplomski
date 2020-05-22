class Q
{
static boolean valueset=false;
static int i;
static Object myLock = new Object();
}

public void put() {
    synchronized (Q.myLock) { 
        while (Q.valueset) {
            try {
                Q.myLock.wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        Q.i++; //you forgot this as well
        System.out.println("Put:" + Q.i);
        Q.valueset = true;
        Q.myLock.notify();
    }
}