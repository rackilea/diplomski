List<String> commands = new ArrayList<String>();
commands.add("C:\\Program Files\\Java7\\jdk1.7.0_79\\bin\\java.exe");
commands.add("-version");
ProcessBuilder pb = new ProcessBuilder(commands);
        // pb.directory(new File("C:\\Program Files\\Java7\\jdk1.7.0_79\\bin"));
Process p = pb.start();
int errCode = p.waitFor();
System.out.println(errCode);
BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getErrorStream()));
String s = null;
while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }