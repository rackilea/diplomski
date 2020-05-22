public class PingDemo {    
    public static void main(String[] args) {
        String ip = "localhost";
        String time = "";

        //The command to execute
        String pingCmd = "ping " + ip;

        //get the runtime to execute the command
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(pingCmd);

            //Gets the inputstream to read the output of the command
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //reads the outputs
            String inputLine = in.readLine();
            while ((inputLine != null)) {
                if (inputLine.length() > 0 && inputLine.contains("time")) {
                     time = inputLine.substring(inputLine.indexOf("time"));
                     break;                        
                }
                inputLine = in.readLine();
            }    
            System.out.println("time --> " + time);    
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}