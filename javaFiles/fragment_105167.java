import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class program7 {

    public static void main(String args[]) {
        String serviceName = ""; // Insert your service name
        try {
            stopService(serviceName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void stopService(String serviceName) throws IOException,
            InterruptedException {

        String executeCmd = "cmd /c net stop \"" + serviceName + "\"";
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();

        System.out.println("processComplete: " + processComplete);

        if (processComplete == 1) {// if values equal 1 process failed
            System.out.println("Service failed");
        }

        else if (processComplete == 0) {
            System.out.println("Service Success");
        }

    }
}