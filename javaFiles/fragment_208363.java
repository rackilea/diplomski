public class Threads extends Thread{
 public static void main(String[] args) {
        try {
            Addition addrunner = new Addition();
            addrunner.start();
            addrunner.setName("addition");
            addrunner.join(); //main thread waits here, until the addition thread has finished executing

            Subtraction subrun = new Subtraction();
            subrun.setName("subtraction");
            subrun.start();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}

class Addition extends Thread{
    public void run() {

        for(int i = 0; i<=20; i++) {
            System.out.println("Number: " + i + " - Thread name is: " + Thread.currentThread().getName());

        }
    }
}


class Subtraction extends Thread{
    public void run() {
        for(int i = 20; i>= 0; i--) {
            System.out.println("Number: " + i + " - Thread name is: " + Thread.currentThread().getName());
        }
    }
}