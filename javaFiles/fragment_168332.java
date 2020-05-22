public class App {
    public static void main(String[] args) throws Exception {
      Bean bean = new Bean();
      for (; ;) {
        bean.foo();
        Thread.sleep(1000);
      }
    }
  }

 public class Bean {
   public void foo(){
     System.out.println("Hello jrebel");
   }
 }