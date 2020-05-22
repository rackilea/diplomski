String[] command = { "cmd", "/c", "copy C:\\output\\html\\*.txt C:\\output\\" };
ProcessBuilder copyFiles = new ProcessBuilder(command);
copyFiles.redirectErrorStream(true);
p = copyFiles.start();

// The InputStream we get from the Process reads from the standard output
// of the process (and also the standard error, by virtue of the line
// copyFiles.redirectErrorStream(true) ).
BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
do {
    line = reader.readLine();
    if (line != null) { System.out.println(line); }
} while (line != null);
reader.close();

p.waitFor();