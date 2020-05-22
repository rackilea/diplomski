ProcessBuilder pb = new ProcessBuilder("/bin/sh");
Process p = pb.start();
try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()),true)) {
    String line = null;
    pw.println("ls");
    pw.println("pwd");
    pw.println("echo quit"); // this gives me output I can test for to break the loop
    pw.flush();
    while ((line = br.readLine()) != null && !line.contains("quit")) {
        System.out.println("line = " + line);
    }
}
int retcode = p.waitFor();
System.out.println("process ended with " + retcode);