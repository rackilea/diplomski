public class TryThreads {
static void someMethod() throws Exception {
    System.out.println("hello");
    throw new Exception();
}

public static void main(String[] args) throws InterruptedException {

    Thread T = new Thread(new Runnable() {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getState());
            try {
                someMethod();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("still here");
        }

    });
    T.start();
    Thread.currentThread().sleep(1000);
    System.out.println(T.getState());
}
}