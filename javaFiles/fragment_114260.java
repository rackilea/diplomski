public static void main( String[] args ) throws Exception {

    // Vars
    Process process;
    String output;

    // Execution
    process = Runtime.getRuntime().exec("cmd /c wmic process call create calc.exe | findstr ProcessId");
    output = readTrimmedOutput(process.getInputStream());
    System.out.println("Output from command: " + output);

    // Basic string manipulation to get process id
    String str_proc_id = output.split(" = ")[1].replace(";","");
    System.out.println("ProcessId is: " + str_proc_id);

    // Some thread delay that you can comment/uncomment for testing if running or not
    Thread.sleep(5000);

    // Finding if process is still running
    process = Runtime.getRuntime().exec("cmd /c wmic process get processid | findstr " + str_proc_id);
    output = readTrimmedOutput(process.getInputStream());

    boolean isRunning = output.contains(str_proc_id);
    System.out.println("Is process still running? " + isRunning);

}

private static String readTrimmedOutput(InputStream is) throws Exception {
    BufferedReader breader = new BufferedReader(new InputStreamReader(is));
    String line = breader.readLine();
    return line != null ? line.trim() : "";
}