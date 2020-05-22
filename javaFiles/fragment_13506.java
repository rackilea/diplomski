OutputStream stdin = null;
InputStream stderr = null;
InputStream stdout = null;
Process process = Runtime.getRuntime ().exec ("...");
stdin = process.getOutputStream ();
stderr = process.getErrorStream ();
stdout = process.getInputStream ();
// "write" the parms into stdin
String line = "data\n";   
stdin.write(line.getBytes());
stdin.flush();
stdin.close();
// clean up if any output in stdout
BufferedReader brCleanUp = 
  new BufferedReader (new InputStreamReader (stdout));
while ((line = brCleanUp.readLine ()) != null) {
  //System.out.println ("[Stdout] " + line);
}
brCleanUp.close();

// clean up if any output in stderr
brCleanUp = 
  new BufferedReader (new InputStreamReader (stderr));
while ((line = brCleanUp.readLine ()) != null) {
  //System.out.println ("[Stderr] " + line);
}
brCleanUp.close();