public class Common {     
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void synchronizedMethod1() {
        rwLock.writeLock().lock();
        try {
            System.out.println("synchronizedMethod1 called");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronizedMethod1 done");
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    public void method1() {
        rwLock.readLock().lock();
        try {
            System.out.println("Method 1 called");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Method 1 done");
        } finally {
            rwLock.readLock().unlock();
        }
    }
}