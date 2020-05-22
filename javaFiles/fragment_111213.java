Explanation: 
                1. Create a command string and then write this command in some .bat file and then execute this .bat file.
                2. (Code not posted here for this ==> )After executing this, you need to put a wait until appium server is started, you can do this by sending request to http://localhost:4723, wait until you get response from this url and then you can initiate the driver.

                    //Getting temp dir
                    String tempDir = System.getProperty("java.io.tmpdir").toString();
                    logFile = new File(tempDir+"\\applog.txt");

                    String commandFile = "C:\\appium_commands.bat";

                    String nodeExe = "C:\\node.exe";
                    String appiumJs = "C:\\node_modules\\appium\\bin\\Appium.js");

                    String strText = "start /B " + nodeExe + "  " + appiumJs + " -g " + logFile.toString() + " --full-reset --command-timeout 90 ";

                    logger.info("****** STARTING APPIUM SERVER USING COMMAND: "+strText);

                    WriteTextInFile(commandFile, strText);
                    Runtime.getRuntime().exec(commandFile);

            *********************  Code to Write Text in File  ***********
            WriteTextInFile(String commandFile, String strText)
           {
            FileWriter writer = new FileWriter(file);
            writer.write(strText);
            writer.close();
          }

          ************ Code to Send GET Request and Check Response *******
    //In this code, you can keep on checking until you get NON-Empty //result.tostring(); Also download and add apache httpclient-4.XXX.jar and //httpcore-4.XXX.jar to your project.

    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    import org.apache.http.client.methods.CloseableHttpResponse;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.conn.HttpHostConnectException;
    import org.apache.http.impl.client.CloseableHttpClient;
    import org.apache.http.impl.client.HttpClients;

    public class Test {

        public static void main(String[] args) {

            String ServerURL = "http://localhost:4723";
            StringBuffer result = new StringBuffer();
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse response = null;

            try 
            {
                httpclient = HttpClients.createDefault();

                ServerURL = ServerURL.replace("%%", "").trim();
                HttpGet GetRequest = new HttpGet(ServerURL);
                try{
                    response = httpclient.execute(GetRequest);
                }catch(HttpHostConnectException h){
                    System.out.println("Couldn't connect to host: "+ServerURL);
                }

                BufferedReader rd = null;
                try{
                    rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
                }catch(NullPointerException e){
                    System.out.println("no response received.. ");
                }

                if(rd != null)
                {
                    String line = "";
                    while ((line = rd.readLine()) != null)
                    {
                        result.append(line);
                    }
                }
            } 
            catch(Exception e)
            {
            }
            finally 
            {
                try{
                    response.close();
                    httpclient.close();
                }
                catch(Exception e){
                }

            System.out.println("Final Response: "+result.toString());
            }
        }

    }

*********** node.json to be used with appium ***********



{
 "capabilities":
  [
{
"version":"4.4.2",
"maxInstances": 3,
"platformName":"ANDROID"
}
],
"configuration":
{
"cleanUpCycle":2000,
"timeout":30000,
"proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
"url":"http://WHERE_APPIUM_RUNNING_IP:4723/wd/hub",
"host": "WHERE_APPIUM_RUNNING_IP",
"port": 4723,
"maxSession": 6,
"register": true,
"registerCycle": 5000,
"hubPort": 4444,
"hubHost": "WHERE_GRID_RUNNING_IP"
}
}