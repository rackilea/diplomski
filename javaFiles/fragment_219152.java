public class BExecutor extends Executor {

    public void performTask() {
      System.out.println("launching handle from B");
      //create or get data to perform the task on
      B b = new B();
      String name = b.getName();
      System.out.println("I am from "+name);

    }
}