String[] foo = {"-t", "-c", "myconfigfile", "-o", "outputfile"};

Arrays.stream(foo).reduce((arg, val) -> {
    switch (arg) {
        case "-v":
            verbose = true;
            break;
        case "-c":
            configFile = val;
            break;
        case "-o":
            outputFile = val;
            break;
        // Non-exhaustive
    }
    return val;
});