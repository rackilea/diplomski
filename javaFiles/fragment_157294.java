import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadProcser {

    private static final int TIME_WAIT = 500;

    public static void main(String[] args) {
        while (true) {
            String val = getRunTVal();
            try {
                Thread.sleep(TIME_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!val.equals(getRunTVal())) {
                System.out.println("Changed");
            }
        }
    }

    public static String getRunTVal() {
        String runTVal = null;
        try {
            String process;
            Process p = Runtime.getRuntime().exec("cmd /c tasklist /FI \"IMAGENAME eq explorer.exe\"");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                runTVal = process;
                System.out.println(runTVal);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return runTVal;
    }

}