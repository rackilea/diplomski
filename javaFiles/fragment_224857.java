public class MyObj {
  public void doSomething(String param1, Integer param2) {
  }

  private void register() {
    mainApp.registerCommand("doSomething", new MyCommand() {
      @Override public void execute(String[] args) {
        doSomething(args[0], Integer.parseInt(args[1]));
      }});
  }
}