public interface Command {}

public interface MainController<T extends Command> {
  public void run( T command );
}

public class Sub1Command implements Command { ... }

public class Sub1Controller implements MainController<Sub1Command> {
  public void run( Sub1Command command ) { ... }
}