class PHilo implements Runnable {

    public static int turn;

    // First of all we need a shared lock so that every thread can use it
    // Using synchronized(this) won't synchronize at all because each thread will synchronize on itself
    private final static Object lock = new Object();

    // Then we need a way to let each thread know what it should print
    // Following your convention, if myTurn is 0 it'll print A and so on
    private final int myTurn;

    // That's why I added this constructor
    public PHilo(int myTurn) {
        this.myTurn = myTurn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // Now we're syncing on lock which is shared, this prevents 2 thread from printing together and only one is allowed each time
            synchronized (lock) {
                // We need to wait while it's not our turn, and we use the while to prevent spurious wakeups
                while (myTurn != turn) {
                    try {
                        // We wait on the shared lock
                        lock.wait();
                    } catch (InterruptedException ie) {
                    }
                }
                // If we're here it means that we can print since it's our turn, so let's decide what to print
                switch (myTurn) {
                    case 0: {
                        System.out.print("A");
                        turn = 1;
                        // There's no need to notify here
                        break;
                    }
                    case 1: {
                        System.out.print("B");
                        turn = 2;
                        break;
                    }
                    case 2: {
                        System.out.print("C");
                        turn = 0;                            
                        break;
                    }
                }
                // It's always a good idea to use notifyAll instead of notify, so that we can awake all the waiting threads
                // It's thread's responsibility to check if it may run after the notifyAll, so we just wake all of them and let them choose who can go on
                lock.notifyAll();
                System.out.println();
            }
        }
    }
}

class Environment {

    public static void main(String[] args) {

        // We use the parameter for PHilo to identify the different threads
        Thread t1 = new Thread(new PHilo(0));
        Thread t2 = new Thread(new PHilo(1));
        Thread t3 = new Thread(new PHilo(2));

        t1.start();
        t2.start();
        t3.start();

    }
}