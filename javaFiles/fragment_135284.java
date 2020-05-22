public class Main {
public static void main(String[] args) {

    Runnable r = new Runnable(){
        public void run() {
            for (int i=0; i < 10; i++) {
                System.out.println("Thread is running");
            }
            return;
        }
    };

    Thread t=new Thread(r);
    t.start();
    t=null;

    System.out.println("App finished");

}
}