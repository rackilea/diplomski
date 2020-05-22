import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Test {

    public static final byte[] END_MARKER = "$TERMINATE$".getBytes();
    public static final int BODY_LENGTH = 1024768;

    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < BODY_LENGTH; i++) {
            data.append((char) ('a' + ThreadLocalRandom.current().nextInt(('z' - 'a' + 1))));
        }
        final Process process = new ProcessBuilder("java", Test.class.getPackage().getName() + ".Echo")
                .directory(new File("out/production/week 3")) // Change to your output directory
                .start();
        process.getOutputStream().write(data.toString().getBytes());
        process.getOutputStream().write(END_MARKER);
        process.getOutputStream().flush();
        System.out.println("Written!");
        final boolean exitedAfterWroteData = process.waitFor(5, TimeUnit.SECONDS);
        System.out.println(exitedAfterWroteData ? "Complete" : "Running"); // Will print running after 5 seconds
        int read = 0;
        while (process.getInputStream().read() > -1) {
            read++;
        }
        if (read != data.toString().getBytes().length + END_MARKER.length) {
            throw new IllegalStateException("Expected echo to print exactly " + BODY_LENGTH + END_MARKER.length + " symbols!");
        }
        final boolean exitedAfterWeReadData = process.waitFor(50, TimeUnit.MILLISECONDS);
        System.out.println(exitedAfterWeReadData ? "Complete" : "Running"); // Will print complete after a few milliseconds
    }
}