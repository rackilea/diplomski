public class MyPush implements Runnable {

    public void run() {
         long twentySeconds = 20*1000L;
        while(true) {
          //execute your code
           Thread.sleep(twentySeconds);
        }
    }

    public static void main(String args[]) {
        (new Thread(new MyPush())).start();
    }

}