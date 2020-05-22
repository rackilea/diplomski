package servicestarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceStarter {

public static void main(String[] args) {
    try {
        ServiceStarter ss = new ServiceStarter();
        String serviceName = "MySQL80";
        String serviceStatus = ss.getServiceState(serviceName);

        if ("STOPPED".equals(serviceStatus)) {
            System.out.println("Service " + serviceName + " is stopped. Starting the service...");
            String shortcut = "D:\\temp\\netstartmysql80.bat.lnk";
            Process process = ss.startService(shortcut);
            // Display any error output. Should be nothing there if all goes well...
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

private String getServiceState(String serviceName) throws IOException {
    String state = "";
    Process process = Runtime.getRuntime().exec("cmd.exe /c sc query " + serviceName);
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;

    while ((line = reader.readLine()) != null) {
        if (line.contains("STATE")) {
            String[] tokens = line.split("\\s+");
            state = tokens[tokens.length - 1];
            break;
        }
    }
    reader.close();
    return state; // Returns "STOPPED" or "RUNNING", or empty string for invalid service name.
}

private Process startService(String shortcut) throws IOException {
    return Runtime.getRuntime().exec("cmd.exe /c " + shortcut);
}
}