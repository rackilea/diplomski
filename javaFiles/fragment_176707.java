Process cmdProc = Runtime.getRuntime().exec(command);


BufferedReader stdoutReader = new BufferedReader(
         new InputStreamReader(cmdProc.getInputStream()));
String line;
while ((line = stdoutReader.readLine()) != null) {
   // process procs standard output here
}

BufferedReader stderrReader = new BufferedReader(
         new InputStreamReader(cmdProc.getErrorStream()));
while ((line = stderrReader.readLine()) != null) {
   // process procs standard error here
}

int retValue = cmdProc.exitValue();