import org.apache.commons.cli.*;

public class CLITestMain {

    public static void main(String[] args) throws ParseException {
        // create Options object
        Options options = new Options();

        // add a option
        options.addOption("a", "argumentName", true, "Do something");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        if(cmd.hasOption("a")) {
            System.out.println("You nailed it!");
            System.out.println(cmd.getOptionValue("a"));
        }
        else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "CLITestMain", options );
        }
    }
}