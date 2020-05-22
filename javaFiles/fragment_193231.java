public class Test {
    public static boolean foo = false;

    public static void main(String[] args) {

        new Thread(new Runnable(){

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Swapping");
                        Test.foo = !Test.foo;
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        while(true) {
            if(Test.foo) {
                System.out.println("I'm here");

            }

        }

    }
}