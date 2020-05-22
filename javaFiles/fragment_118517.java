if (randomSeed != -1) {
    args.add(7, "--seed");
    args.add(8, Integer.toString(randomSeed));
}

// this avoids validation of the input xml files; if SUMO_HOME is not set correctly,
// sumo will try to download the schema files from the web and may wait 30 seconds at startup
// for the connection to time out.
args.add(9, "--xml-validation");
args.add(10, "never");