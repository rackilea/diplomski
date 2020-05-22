public class CustomConsole {

    private BufferedReader reader;

    public String readLine(String format, Object... args) {
        if (System.console() != null) {
            return System.console().readLine(format, args);
        }

        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            return reader.readLine();
        } catch (IOException e) {
            Logger.fatal(e.getMessage());
            System.exit(-1);
            return null;
        }
    }

// ....