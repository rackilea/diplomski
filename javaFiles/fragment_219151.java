public abstract class Executor {
    public abstract void performTask();
    public static void execute(String condition) {
       Executor executor = null;
       if ( condition.equals("xyz")) {
          executor = new AExector();
       } else {
          executor = new BExecutor();
       }
       executor.performTask();
    }

}