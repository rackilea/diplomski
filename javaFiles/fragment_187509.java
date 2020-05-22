package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaProcessSearch {

    public static void main(String[] args) throws IOException {
        boolean isProcessRunning = isAJavaProcessWithMainClass("process.JavaProcessSearch");
        System.out.println(isProcessRunning);
    }

    public static boolean isAJavaProcessWithMainClass(String mainClass) {
        Process p;
        try {
             String javaHome = System.getenv("JAVA_HOME");
             p = Runtime.getRuntime().exec(javaHome + File.separator + "bin/jps -l");

            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                if (line.contains(mainClass)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}