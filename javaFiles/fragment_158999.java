Process p = Runtime.getRuntime().exec(cmd);
BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = input.readLine();
while (line != null) {
  // process output of the task
  // ...
}
input.close();
// wait for the task complete
p.waitFor();
int ret = p.exitValue();
// process the task result
// ...