public static boolean runSqlScript(String filename, String user, String password) {
    ProcessBuilder pb = new ProcessBuilder("mysql", "-u"+user, "-p"+password);
    try {
        Process pr = pb.start();
        BufferedReader errors = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
        BufferedReader output = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        BufferedWriter input = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
        input.write("source " + filename + ";");
        input.flush();
        input.write("quit;");
        input.flush();
        input.close();
        while (pr.isAlive()) {
            try {
                System.err.println(errors.readLine());
                System.out.println(output.readLine());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.err.println(errors.readLine());
        System.out.println(output.readLine());

        int status = pr.exitValue();
        return (status == 0);
    } catch (IOException e) {
        System.err.println("Error running command: " + e.getMessage());
        return false;
    }
}