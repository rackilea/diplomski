private static final Semphore semaphore = new Semaphore(2);

public static void myFunct() throws InterruptedException {
    semaphore.aquire();
    try {
        // do stuff
    } finally {
        semaphore.release();
    }
}