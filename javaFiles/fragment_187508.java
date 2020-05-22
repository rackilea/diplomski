import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdProcessSearch {

    public static void main(String[] args) throws IOException {
        boolean anyCmdProgramOpened = isAnyCmdProgramOpened();
        System.out.println("isOpened = " + anyCmdProgramOpened);
    }
    public static boolean isAnyCmdProgramOpened() {
        Process p;
        try {
            p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("cmd.exe")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}