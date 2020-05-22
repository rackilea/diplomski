Options options = new Options();

    Option option = new Option(null, "help", true, "some desc");

    options.addOption(option);

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse( options, new String[] {"--help=foobar"});

    // automatically generate the help statement
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp( "ant", options );

    assertEquals(cmd.hasOption("help"), true); 
    String optionValue = cmd.getOptionValue("help"); 
    assertEquals("foobar", optionValue);