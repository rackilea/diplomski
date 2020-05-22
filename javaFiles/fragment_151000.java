try {
    Process proc = Runtime.getRuntime().exec("nmap -PR -sn 192.168.1.0/24");

    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

    // read the output from the command
    String s = null;

    while ((s = stdInput.readLine()) != null) {
        System.out.println(s);

    // read any errors from the attempted command
    while ((s = stdError.readLine()) != null) {
        System.err.println(s);
    }
} catch (IOException ex) {
    System.err.println(ex);
}