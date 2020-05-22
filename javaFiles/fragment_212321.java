Process proc = Runtime.getRuntime().exec("cat /home/uhf/metrics.sh");
String s = null;
BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

// read the output from the command
System.out.println("Here is the standard output of the command:\n");
while ((s = stdInput.readLine()) != null) {
        System.out.println(s);
}

// read any errors from the attempted command
System.out.println("Here is the standard error of the command (if any):\n");
while ((s = stdError.readLine()) != null) {
    System.out.println(s);
}