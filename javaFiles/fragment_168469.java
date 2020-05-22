import java.util.concurrent.Semaphore;

public class ThreadCoordinator {

        private static ThreadCoordinator tc = new ThreadCoordinator();
        private static Semaphore semaphore = new Semaphore( 1, true );      
        private static String identity;

        // singleton get instance
        public static ThreadCoordinator getInstance() {
            return ThreadCoordinator.tc;
        }

        public void setIdentity( String identity ) throws InterruptedException {
            ThreadCoordinator.identity = identity;
        }


        public String getIdentity() throws InterruptedException {
            String identity = ThreadCoordinator.identity;
            ThreadCoordinator.identity = null;
            return identity;
        }

        public void acquire() throws InterruptedException {
            ThreadCoordinator.semaphore.acquire();
        }

        public void release() {
            ThreadCoordinator.semaphore.release();
        }

 }