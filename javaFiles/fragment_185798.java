package so32589604;

import org.apache.commons.io.IOUtils;

public class App {
    public static void main(String[] args) throws Exception {
        final Runtime runtime = Runtime.getRuntime();
        final Process proc = runtime.exec("java -version");
        proc.waitFor();
        // IOUtils from apache commons-io
        final String capturedOut = IOUtils.toString(proc.getErrorStream());

        System.out.println("output = " + capturedOut);
        if(capturedOut.isEmpty()) {
            throw new IllegalArgumentException("Java not found.");
        }
    }
}