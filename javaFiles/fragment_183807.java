@Command(name = "cli", version = "1.0",
    mixinStandardHelpOptions = true,
    subcommands = {Create.class, ListObjects.class})
public class Cli implements Runnable {
    @Option(names = {"--field1"}, required = true)
    private String field1;

    @Option(names = {"--field2"}, required = true)
    String field2;

    @Option(names={"--field3"}, required = true)
    String field3;

    // not needed because we have mixinStandardHelpOptions=true
    //@Option(names = {"-h", "--help"}, usageHelp = true) boolean help;

    public void run() {
        // business logic of the top-level cmd here
        System.out.println("hi, field1="+field1);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Cli()).execute(args);
        System.exit(exitCode);
    }
}

@Command(name = "create", description = "create ...",
        mixinStandardHelpOptions = true, version = "1.0")
class Create implements Callable<Integer> {
    @Option(names = {"-x", "--times"}, description = "...")
    int x;

    @Override
    public Integer call() {
        // business logic for "create" here...
        return ok ? 0 : 1; // exit code support
    }
}

@Command(name = "list", description = "create ...",
        mixinStandardHelpOptions = true, version = "1.0")
class ListObjects implements Runnable {
    @Option(names = {"-x", "--times"}, description = "...")
    int x;

    @Override
    public void run() {
        // business logic for "list" here...
    }
}