Process p = Runtime.getRuntime().exec(command, null, new File(workingDirectory));
// send input vi stdin
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
writer.write("\n>>>>>>>>>>");
writer.write(inputJsonString);
writer.write("<<<<<<<<<<\n");
writer.flush();

try{ 
BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
for (;;)
{
    String line = reader.readLine();
    if (line == null)
    {
        break;
    }
    // System.out.println(line);
    outputString += line + "\n";
}
 p.getOutputStream().close();
 p.getInputStream().close();
}
catch(Exception e)
{
   e.printStackTrace();
}
if (JniSettings.isLinux())
{
    p.waitFor();
}
else
{
    // System.out.println("ExecJniApp: windows wait for");
}
// exit code of command and log error detail
// exit status = 0 -> Success
exitStatus = p.exitValue();
if (exitStatus != 0)
{
    System.out.println("ExecJniApp: inputJsonString: " + inputJsonString);
    System.out.println("ExecJniApp: outputString:\n" + outputString);
    throw new Exception("Exit status other than zero :- " + exitStatus + "\noutput: ");
}