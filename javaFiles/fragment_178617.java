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
    p.waitFor();
} catch (IOException ioe) {
    ioe.printStackTrace();
}