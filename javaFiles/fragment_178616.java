try {
    String[] cmd = {"cmd", 
                    "/c", 
                    "gradlew", 
                    "assembleRelease"};
    ProcessBuilder pb = new ProcessBuilder(cmd);
    // Change working directory
    pb.directory(new File("C:\\Users\\CA_LTD\\AndroidStudioProjects\\AMBITION"));
    // Run command
    Process p = pb.start();
    // Wait for completion
    int exitValue = p.waitFor();
    // Check exit value
    if (exitValue != 0) {
        // TODO: Define your behaviour when process exits with non-zero exit value

        // Print command output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream());
        String outLine = null;
        while ( (outLine = reader.readLine()) != null) {
            System.out.println(outLine);
        }

        // Print command error
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream());
        String errLine = null;
        while ( (errLine = reader.readLine()) != null) {
            System.err.println(errLine);
        }

        // Throw exit value exception
        throw new Exception("ERROR: CMD process exited with non-zero value: " + exitValue);
    }
} catch (IOException ioe) {
    ioe.printStackTrace();
}