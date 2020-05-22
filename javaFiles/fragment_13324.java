String exportCommand = cassandraHome + "bin/cqlsh " + hostname + " " + rpcPort + " -f command.txt"; // file which holds export command

    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec(exoprtCommand);

    // for keep tracking the log, you can do following. 
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = null;

    while ((line = br.readLine()) != null)
    {

    }