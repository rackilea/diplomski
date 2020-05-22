public static void main(String args[]){
    // create Options object
    Options options = new Options();

    // add t option
    options.addOption("t", false, "display current time");

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse( options, args);

    if(cmd.hasOption("t")) {
        // print the date and time
    }
    else {
        // print the date
    }
}