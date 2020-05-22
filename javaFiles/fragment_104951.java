public static boolean runSqlScriptRuntime(String filename, String user, String password) {
    Runtime rt = Runtime.getRuntime();
    try {
        String cmd = "cmd /c mysql -u " + user + " -p" + password + " < " + filename;
        System.out.println(cmd);
        Process pr = rt.exec(cmd);
        BufferedReader errors = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
        BufferedReader output = new BufferedReader(new InputStreamReader(pr.getInputStream()));
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