import java.io.*;

public class Test {
    public static void main(String args[]) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("java", "other.Program");
        pb.redirectErrorStream();
        Process p = pb.start();
        InputStream is = p.getInputStream();
        int ch;
        while ((ch = is.read()) != -1)
            System.out.print((char) ch);
        is.close();
        System.out.println("Client program done.");
    }
}