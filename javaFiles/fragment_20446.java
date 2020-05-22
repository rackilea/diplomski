import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Your script
        String script = getScriptFromSomewhere();

        // create a temp file and write your script to it
        File tempScript = File.createTempFile("temp_scripts_", "");
        tempScript.setExecutable(true);
        try (OutputStream output = new FileOutputStream(tempScript)) {
            output.write(script.getBytes());
        }

        // build the process object and start it
        List<String> commandList = new ArrayList<>();
        commandList.add(tempScript.getAbsolutePath());
        ProcessBuilder builder = new ProcessBuilder(commandList);
        builder.redirectErrorStream(true);
        builder.environment().put("param1", "abc");
        builder.environment().put("param2", "xyz");
        Process shell = builder.start();

        // Start the interrupting thread
        long timeoutMillis = 5000;
        ExecutingThread thread = new ExecutingThread(shell, timeoutMillis);
        thread.start();

        // read the output and show it
        byte[] buffer = new byte[1024];
        try (InputStream input = shell.getInputStream()) {
            int read;
            while ((read = input.read(buffer)) != -1) {
                String text = new String(buffer, 0, read);
                System.out.print(text);
            }
        }

        // wait for the process to finish (or be interrupted)
        thread.join();

        if(!thread.isFinished()) {

            System.out.println("PROCESS WAS INTERRUPTED");

        } else {

            // check the exit code (exit code = 0 usually means "executed ok")
            System.out.println("PROCESS FINISHED, EXIT CODE: " + thread.getExitValue());

        }


        // delete your temp file
        tempScript.delete();
    }
}

class ExecutingThread extends Thread {

    private long timeoutMillis;
    private WaitingThread waitingThread;

    public ExecutingThread(Process shell, long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
        this.waitingThread = new WaitingThread(shell);
    }

    @Override
    public void run() {
        waitingThread.start();
        try {
            waitingThread.join(timeoutMillis);
        } catch (InterruptedException ignore) {
        }
        if(waitingThread.isAlive()) {
            waitingThread.interrupt();
        }
    }

    public int getExitValue() {
        return waitingThread.getExitValue();
    }

    public boolean isFinished() {
        return waitingThread.isFinished();
    }

}


class WaitingThread extends Thread {

    private Process shell;
    private volatile int exitValue;
    private volatile boolean finished = false;

    public WaitingThread(Process shell) {
        this.shell = shell;
    }

    @Override
    public void run() {
        try {
            exitValue = shell.waitFor();
            finished = true;
        } catch (InterruptedException e) {
            shell.destroy();
        }
    }

    public int getExitValue() {
        return exitValue;
    }

    public boolean isFinished() {
        return finished;
    }

}