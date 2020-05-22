import java.io.*;

public class Test {
    public static void main(String... args) throws IOException {

        ProcessBuilder pb =
                new ProcessBuilder("java", "-cp", "yourClassPath", "HelloWorld");

        pb.redirectErrorStream(true);
        Process proc = pb.start();

        Reader reader = new InputStreamReader(proc.getInputStream());
        int ch;
        while ((ch = reader.read()) != -1)
            System.out.print((char) ch);
        reader.close();
    }
}