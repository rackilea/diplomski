// Generic interface for when a client doesn't care
// about the return value of a command.
public interface Command {
    // The interfaces themselves take a String[] rather
    // than a String... argument, because otherwise the
    // implementation of AbstractCommand<T> would be
    // more complicated.
    public void execute(String[] arguments);
}

// Interface for clients that do need to use the
// return value of a command.
public interface ValuedCommand<T> extends Command {
    public T evaluate(String[] arguments);
}

// Optional, but useful if most of your commands are ValuedCommands.
public abstract class AbstractCommand<T> implements ValuedCommand<T> {
    public void execute(String[] arguments) {
        evaluate(arguments);
    }
}

// Singleton class with utility methods.
public class Commands {
    private Commands() {} // Singleton class.

    // These are useful if you like the vararg calling style.
    public static void execute(Command cmd, String... arguments) {
        cmd.execute(arguments);
    }

    public static <T> void execute(ValuedCommand<T> cmd, String... arguments) {
        return cmd.evaluate(arguments);
    }

    // Useful if you have code that requires a ValuedCommand<?>
    // but you only have a plain Command.
    public static ValuedCommand<?> asValuedCommand(Command cmd) {
        return new VoidCommand(cmd);
    }

    private static class VoidCommand extends AbstractCommand<Void> {
        private final Command cmd;

        public VoidCommand(Command actual) {
            cmd = actual;
        }

        public Void evaluate(String[] arguments) {
            cmd.execute(arguments);
            return null;
        }
    }
}