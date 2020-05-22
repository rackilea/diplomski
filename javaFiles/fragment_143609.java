public class Foo {
    void bar(Runnable function) {
       for(int i = 0; i < 5; i++) {
           function.run();
       }
    }

    static void myFunction() {
         System.out.println("my Function!");
    }

    public static void main(String[] ignored) {
         Foo f = new Foo();
         f.bar( new Runnable() { public void run() {
             myFunction();
         }});
    }

}