public class CommandExec implements Callable{

 @Override
 public Object onCall(MuleEventContext eventContext) throws Exception {

    Runtime rt = Runtime.getRuntime();

    Process proc = rt.exec("/your_path/test.sh");
    int returnCode = proc.waitFor(); 

    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

    StringBuffer finalResult = new StringBuffer();
    finalResult.append("results:" + "\n");

    String results = "";
    while ((results = stdInput.readLine()) != null) {
       finalResult.append(results + "\n");
    }

    finalResult.append(" errors:");
    String errors = "";
    while ((errors = stdError.readLine()) != null) {
         finalResult.append(errors + "\n");
    }

    return finalResult;
 }
}