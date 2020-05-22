import java.io.*;
import java.util.*;

public class RunFile {
    public static void main(String args[]) throws Exception {
        File f = new File(args[0]); // .py file (e.g. bob/script.py)

        String dir = f.getParent(); // dir of .py file
        String file = f.getName(); // name of .py file (script.py)
        String module = file.substring(0, file.lastIndexOf('.'));
        String command = "import " + module + "; " + module + "." + args[1];
        List<String> items = Arrays.asList("python", "-c", command);
        ProcessBuilder pb = new ProcessBuilder(items);
        Map<String, String> env = pb.environment();
        env.put("PYTHONPATH", dir);
        pb.redirectErrorStream();
        Process p = pb.start();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        System.out.println("Running Python starts: " + line);
        int exitCode = p.waitFor();
        System.out.println("Exit Code : " + exitCode);
        line = bfr.readLine();
        System.out.println("First Line: " + line);
        while ((line = bfr.readLine()) != null) {
            System.out.println("Python Output: " + line);
        }
    }
}