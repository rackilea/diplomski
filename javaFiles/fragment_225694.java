public class TestWait extends Thread{
    static TestWait t1;
    static TestWait t2;

    private boolean flag

    public TestWait(boolean wait) {
         this.flag=wait;
    }

    public void run() {


     while(true) {
            try {
                if (flag) {
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }

    public static void main(String [] args) throws InterruptedException {
        t1 = new TestWait(true);
        t2 = new TestWait(false);

        t1.start();
        t2.start();

        t1.setName("t1");
        t2.setName("t2");
    }

}