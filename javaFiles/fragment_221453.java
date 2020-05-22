public class App {

    public static void main(String args[]) {

        SharedObject sharedObject = new SharedObject();

        Thread evenThread = new Thread(new EvenNumber(sharedObject));
        Thread oddThread = new Thread(new OddNumber(sharedObject));

        evenThread.start();
        oddThread.start();
    }

}


class EvenNumber implements Runnable {
    SharedObject object;

    public EvenNumber(SharedObject object) {
        this.object = object;
    }

    public void run() {
        int i = 0;
        while(i <= 100) {
            object.getLock().lock();
            try {
                if (!object.isOdd()) {
                    System.out.println("Even : " + i);
                    i = i + 2;
                    object.setOdd(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                object.getLock().unlock();

            }
        }
    }
}

class OddNumber implements Runnable {
    SharedObject object;

    public OddNumber(SharedObject object) {
        this.object = object;
    }

    public void run() {
        int i = 1;
        while(i <= 100) {

            object.getLock().lock();
            try {
                if(object.isOdd()) {
                    System.out.println("Odd : " + i);
                    i = i + 2;
                    object.setOdd(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                object.getLock().unlock();

            }

        }

    }
}

class SharedObject {
    private Lock lock;
    private boolean isOdd;

    public SharedObject() {
        this.lock = new ReentrantLock(true);

    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean isOdd) {
        this.isOdd = isOdd;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

}