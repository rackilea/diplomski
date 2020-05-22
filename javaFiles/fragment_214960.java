public class Test {
      public static void main(String[] args) throws Exception {
        System.setOut(new StorePrintStream(System.out));
        System.out.println("print line");
        Test2 t2 = new Test2();
        t2.meth1();
        System.out.println(StorePrintStream.printList);
      }
    }

class Test2 {
    public void meth1() {
        System.out.println("another print");
    }
}