public class Customer extends Thread {
    Taxi taxi;

    public Customer(Taxi taxi){
        this.taxi = taxi;
    }

    public  void run(){
        //System.out.println(t.hashCode());

        System.out.println("Customer "+Thread.currentThread().getName()+" trying to BOOK taxi");
        try {
            taxi.book();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer "+Thread.currentThread().getName()+" is currently USING taxi");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Customer "+Thread.currentThread().getName()+" RELEASING taxi");
        try {
            taxi.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}