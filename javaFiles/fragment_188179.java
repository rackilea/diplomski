public class FileReceiver {

    static PrintWriter pw;
    static DateFormat df;

    static {
        try {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
            pw = new PrintWriter("result.log");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                pw.close();
                System.exit(1);
            }
        });
    }

    public static void logToFile(LoggingEvent event) {
        String nowAsString = df.format(new Date(event.getTimeStamp()));

        pw.println("[" + nowAsString + "]" + " [" + event.getThreadName() + "]"
                + " [" + event.getLoggerName() + "]" + " ["
                + event.getMessage() + "]");
        pw.flush();


    }
}