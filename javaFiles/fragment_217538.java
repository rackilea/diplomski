public class TestExample {

         public static void main(String[] args) {

            final TestExample  test = new TestExample();



          Thread t =  new Thread(new Runnable() {

                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName());
                    test.dance();
                }
            });
          t.setName("Child Thread");
          t.start();

        }

        public void dance() {
            System.out.println(Thread.currentThread().getName());
        }



}