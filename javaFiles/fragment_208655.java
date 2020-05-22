public class Taxi {
    Boolean BOOKED = false;
    String id;

    void book() throws InterruptedException {
        synchronized (this) {
            while (BOOKED) {
                this.wait();
            }
            try {
                setId(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BOOKED = true;
            System.out.println("Customer " + Thread.currentThread().getName() + " BOOKED taxi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    void release() throws InterruptedException {
        synchronized (this) {
            BOOKED = false;
            System.out.println("Customer " + Thread.currentThread().getName() + " RELEASED taxi");
            this.notifyAll();
        }
    }

    void setId(String id) throws InterruptedException {
        System.out.println("SETTING ID TO CUSTOMER " + Thread.currentThread().getName());
        this.id = id;
    }

    String getId() {
        return id;
    }
}