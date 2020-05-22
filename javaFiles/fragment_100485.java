public interface Command<T> {
  T execute();
}

public class VoidReturningCommand implements Command<Void> {
  public Void execute() {
    // executes ....
    return null; // don't care about the return...
  }
}