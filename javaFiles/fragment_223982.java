Option singleMandatory1 = Option.builder("sm1")
            .argName("value")
            .hasArg()
            .required()
            .build();
    Option singleMandatory2 = Option.builder("sm2")
            .argName("value")
            .hasArg()
            .required()
            .build();
    Option multipleOptional = Option.builder("mo")
            .argName("value1,value2,...,valueN")
            .hasArgs()
            .valueSeparator(',')
            .build();
    Option dummyOptional = Option.builder("s")
            .build();

    Options options = new Options();
    options.addOption(singleMandatory1);
    options.addOption(singleMandatory2);
    options.addOption(multipleOptional);
    options.addOption(dummyOptional);

    CommandLineParser parser = new DefaultParser();
    CommandLine line = parser.parse(options, args);