import java.lang.ProcessBuilder.Redirect;

public class Main {

    public static void main(String[] args) throws Exception {
        Process process = new ProcessBuilder(args[0])
            .redirectOutput(Redirect.INHERIT)
            .redirectError(Redirect.INHERIT)
            .start();

        Thread thread = new Thread(() -> readInput(args[1]));
        thread.setDaemon(true);
        thread.start();

        process.waitFor();
    }

    private static void readInput(String commandLinePart) {
        try {
            while (System.in.read() != -1);
            killProcess(commandLinePart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void killProcess(String commandLinePart) throws Exception {
        final String space = " ";
        String[] commandLine = "wmic process where \"commandLine like '%placeholder%'\" delete"
                .replaceAll("placeholder", commandLinePart).split(space);
        new ProcessBuilder(commandLine).start();
    }
}