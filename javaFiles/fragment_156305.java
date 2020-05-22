public class Test {

        private Map<Object, Object> map = new HashMap<>();
        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        public void process() {
            methodThatModifiesMap();
            methodThatJustReadsmap();
        }

        private void methodThatModifiesMap() {
            //if the code involves modifying the structure of the map like 'put(), remove()' i will acquire the write reentrantReadWriteLock
            reentrantReadWriteLock.writeLock().lock();
            try {
                //DO your thing and put() or remove from map
            }
            finally {
                //Dont forget to unlock
                reentrantReadWriteLock.writeLock().unlock();
            }
        }

        private void methodThatJustReadsmap() {
            // if all you are doing is reading ie 'get()'
            reentrantReadWriteLock.readLock().lock(); // this does not block other reads from other threads as long as there is no writes during this thread's read
            try {

            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }

    }