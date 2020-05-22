import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "push",
        description = "Update remote refs along with associated objects")
class PushCommand implements Runnable {

    @ParentCommand // picocli injects the parent instance
    private GitApp parentCommand;

    public void run() {
        System.out.printf("#PushCommand.call: parent.verbose=%s%n",
                parentCommand.verboseMode); // use parent instance
    }
}

@Command(description = "Version control",
        mixinStandardHelpOptions = true, // auto-include --help and --version
        subcommands = {PushCommand.class,
                       HelpCommand.class}) // built-in help subcommand
public class GitApp implements Runnable {
    @Option(names = {"-v", "--verbose"},
            description = "Verbose mode. Helpful for troubleshooting.")
    boolean verboseMode;

    public void run() {
        System.out.println("#GitApp.call");
    }

    public static void main(String[] args) {
        args = new String[] { "--verbose", "push" };

        GitApp app = new GitApp();
        int exitCode = new CommandLine(app)
            .setExecutionStrategy(new RunAll())
            .execute(args);

        System.out.println("#GitApp.main after. verbose: " + (app.verboseMode));
        System.exit(exitCode);
    }
}