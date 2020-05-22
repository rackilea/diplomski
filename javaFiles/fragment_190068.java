public class StartProcess {
    public static void main(final String[] args) throws IOException, InterruptedException {
        final Process process = Runtime.getRuntime().exec("the app command");
        final InputStream in = process.getInputStream();
        final OutputStream out = process.getOutputStream();
        final InputStream err = process.getErrorStream();
        process.waitFor(); // wait for termination
        final int exitCode = process.exitValue();
    }
}