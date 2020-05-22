//The command to execute
String pingCmd = "ping " + ip + " -t";

//get the runtime to execute the command
Runtime runtime = Runtime.getRuntime();
Process process = runtime.exec(pingCmd);     

//Gets the inputstream to read the output of the command
BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

//reads the outputs
String inputLine = in.readLine();
while ((inputLine != null)) {
    if (inputLine.length() > 0) {
       ........
    }
    inputLine = in.readLine();
}