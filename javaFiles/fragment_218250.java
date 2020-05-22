private static final Options OPTIONS = new Options();
private static final Options HELP_OPTIONS = new Options();
OPTIONS.addOption(OptionBuilder
        .withLongOpt("seq1")
        .withArgName("file1")
        .withDescription(
                "REQUIRED : the file containing sequence 1")
        .hasArg().isRequired().create());
// etc
final Option help = new Option("?", "help", false,
        "print this message and exit");
HELP_OPTIONS.addOption(help);
OPTIONS.addOption(help);
// later
CommandLineParser parser = new GnuParser();
CommandLine line = parser.parse(HELP_OPTIONS, args, true); // true so it
// does not throw on unrecognized options
if (line.hasOption("help")) {
    usage(0); // calls exit
}
line = parser.parse(OPTIONS, args);