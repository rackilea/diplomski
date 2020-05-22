public class CExecutor extends Executor {


    public void performTask() {
      System.out.println("launching handle from C");
       //create or get data to perform the task on
      C c = new C();
      String value = c.getValue();
      System.out.println("I am from "+value);

    }
}