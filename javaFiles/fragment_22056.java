public class ThreadTest implements Runnable {

    public int number = 0;

    public static void main(String[] args) {
        ThreadTest adding = new ThreadTest();
        adding.addingOnes();
        System.out.println(adding.number);
    }

    public void addingOnes()
        Thread t1 = new Thread(this);
        t1.start();
        try {
            t1.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void add() {
        number++;
    }

    public void run() {
        for(int i = 0; i < 10000; i++) {
            add();
        }
    }
}