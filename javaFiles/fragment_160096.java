import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Scanner;

public class WaitForProcessDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = getDummyProcess("Chromedriver");
        System.out.println("Killing...");
        p.destroy();
        System.out.println("Waiting...");
        p.waitFor();
        System.out.println("Done.");
    }

    private static Process getDummyProcess(String exeName) throws IOException {
        ProcessTool tool = new WindowsProcessTool();
        long pid = tool.findProcessByName(exeName);
        return new DummyProcess(pid, tool);
    }

    interface ProcessTool {
        long findProcessByName(String exeName) throws IOException;
        void killProcess(long pid) throws IOException;
        boolean isPidStillThere(long pid);
    }

    private static class WindowsProcessTool implements ProcessTool {

        @Override
        public long findProcessByName(String exeName) throws IOException {
            String processInfoCSV = findProcessInfoCSV("IMAGENAME eq " + exeName);
            String[] fields = processInfoCSV.split("\"");
            String pid = fields[3];
            return Integer.parseInt(pid);
        }

        String findProcessInfoCSV(String filter) throws IOException {
            Process p = new ProcessBuilder("tasklist", "-FO", "CSV", "/FI", filter)
                    .redirectErrorStream(true)
                    .start();
            Scanner scanner = new Scanner(p.getInputStream());
            scanner.nextLine(); // skip header line
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
            throw new IOException("No such process: " + filter);
        }

        @Override
        public void killProcess(long pid) throws IOException {
            new ProcessBuilder("taskkill", "/PID", String.valueOf(pid))
                    .redirectErrorStream(true)
                    .start();
        }

        @Override
        public boolean isPidStillThere(long pid) {
            try {
                findProcessInfoCSV("PID eq " + pid);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }

    private static class LinuxProcessTool implements ProcessTool {

        @Override
        public long findProcessByName(String exeName) throws IOException {
            Process pgrep = new ProcessBuilder("pgrep", exeName)
                    .redirectErrorStream(true)
                    .start();
            Scanner scanner = new Scanner(pgrep.getInputStream());
            return Long.parseLong(scanner.nextLine());
        }

        @Override
        public void killProcess(long pid) throws IOException {
            new ProcessBuilder("kill", String.valueOf(pid))
                    .redirectErrorStream(true)
                    .start();
        }

        @Override
        public boolean isPidStillThere(long pid) {
            return Paths.get("/proc", String.valueOf(pid)).toFile().isDirectory();
        }
    }

    /*
     * Broken & incomplete implementation of java.lang.Process, implemented as an exercise.
     * (Kids, don't do this at home)
     */
    static class DummyProcess extends Process {

        private final long pid;
        private final ProcessTool tool;

        DummyProcess(long pid, ProcessTool tool) {
            this.pid = pid;
            this.tool = tool;
        }

        @Override
        public OutputStream getOutputStream() {
            return null; // DANGER. This cannot be implemented for non-child process.
        }

        @Override
        public InputStream getInputStream() {
            return null; // DANGER. This cannot be implemented for non-child process.
        }

        @Override
        public InputStream getErrorStream() {
            return null; // DANGER. This cannot be implemented for non-child process.
        }

        @Override
        public int waitFor() throws InterruptedException {
            // Very sub-optimal implementation
            boolean isPidPresent = isPidStillThere();
            while (isPidPresent) {
                Thread.sleep(500);
                isPidPresent = isPidStillThere();
            }
            return 0;
        }

        @Override
        public int exitValue() {
            // For example, this is dangerous, as Process.isAlive() will call this, and determine process is not alive.
            // Also, it cannot be implemented correctly, it's not possible to tell what was exit value.
            // At best we could throw IllegalThreadStateException when process is still alive.
            return 0;
        }

        @Override
        public void destroy() {
            try {
                tool.killProcess(pid);
            } catch (IOException e) {
                throw new RuntimeException("Failed to kill process " + pid, e);
            }
        }

        private boolean isPidStillThere() {
            return tool.isPidStillThere(pid);
        }
    }

}