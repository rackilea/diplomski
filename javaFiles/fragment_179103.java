public class Test1 extends Test<B>  {

     public static void main(String[] args) {
        Test1 t = new Test1();

        Class<B> clazz = t.getTheType();

        System.out.println(clazz); // will print 'class B'
        System.out.println(printType()); // will print 'class B'
     }
  }