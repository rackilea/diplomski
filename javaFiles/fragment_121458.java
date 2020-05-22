public class Main {

    public static void main(String[] args) {
        MyHouse house = new MyHouse();
        house.start();
//        house.eatPizza();
        // Halt main thread momentarily to delay Mr Pizza Guy
        try { Thread.sleep(3000); } catch(Exception e) {}
        house.pizzaGuy();

    }
}

class MyHouse extends Thread {

    private boolean pizzaArrived = false;
    private Object lock = new Object();

    @Override
    public void run() {
        eatPizza();
    }

    public void eatPizza() {
        synchronized (lock) {
            while (!pizzaArrived) {
                try {
                    System.out.println("Waiting for Pizza guy");
                    lock.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("Pizza arrived!!!");
        }
        System.out.println("yumyum..");
    }

    public void pizzaGuy() {
        synchronized (lock) {
            this.pizzaArrived = true;
            lock.notifyAll();
        }
    }
}