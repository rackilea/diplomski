private Properties getEnvironmentVariables() throws Throwable {
    Properties environmentVariables = new Properties();
    String operatingSystem = System.getProperty("os.name").toLowerCase();
    Runtime runtime = Runtime.getRuntime();
    Process process = null;
    if (operatingSystem.indexOf("windows 95") > -1
            || operatingSystem.indexOf("windows 98") > -1
            || operatingSystem.indexOf("me") > -1) {
        process = runtime.exec("command.com /c set");
    } else if ((operatingSystem.indexOf("nt") > -1)
            || (operatingSystem.indexOf("windows 2000") > -1)
            || (operatingSystem.indexOf("windows xp") > -1)
            || (operatingSystem.indexOf("windows 2003") > -1)
            || (operatingSystem.indexOf("windows vista") > -1)) {
        process = runtime.exec("cmd.exe /c set");
    } else {
        process = runtime.exec("env");
    }
    BufferedReader environmentStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String inputLine = "";
    int idx = -1;
    while ((inputLine = environmentStream.readLine()) != null) {
        idx = inputLine.indexOf('=');
                inputLine.substring(idx + 1));
    }
}