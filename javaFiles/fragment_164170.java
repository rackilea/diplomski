//***** build up options *****
    Options options = new Options();

    // ... .... ...

    //***** process command line *****
    try {
        MianCLIOptions.initialize(options, args);
    }
    catch (UnrecognizedOptionException ex) {
        // do something
    }