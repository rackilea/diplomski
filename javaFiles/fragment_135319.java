//Create and start process builder
    ProcessBuilder builder = new ProcessBuilder("java", "-jar", path_to_jar_file, param1, param2, param3);
    Process process = builder.start();

    //Create reader to get error messages (Just in case you have another issue)
    BufferedReader errinput = new BufferedReader(new InputStreamReader(
        process.getErrorStream()));

    //Print errors to the terminal/console
    String s = null;
    while ((s = errinput.readLine()) != null)
    {
        System.out.println(s);
    }