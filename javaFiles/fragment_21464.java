public class test{
    public static void main(String[]a){
        System.out.print(foo());
    }

    public static String foo(){
        (new Thread(new fooBar())).start();
        return "foo";
    }
    public static void bar(){
        System.out.println("bar");
    }

    static class fooBar implements Runnable{
        public void run(){
            bar();
        }
    }
}