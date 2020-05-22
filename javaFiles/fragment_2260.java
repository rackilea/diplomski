public static void main(String[] args) throws IOException {
    String folder = "C:\\Apps\\wildfly-8.0.0.Final\\bin";
    String command = "jboss-cli.bat --connect --command=\"deploy --force "
        + "C:\\Users\\me\\git\\test\\Test\\build\\libs\\TestEAR.ear\"";
    ProcessBuilder pb = new ProcessBuilder(command);
    pb.directory(new File(folder));
    pb.inheritIO();
    Process p = pb.start();
    try {
        p.waitFor();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}