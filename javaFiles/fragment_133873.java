// open/close the stream in some kind of static init()/deinit() method
private static PrintStream logStream;
private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd_HH-mm-ss: ");

private static void writeLogToFile(Exception e) {
    logStream.println(sdf.format(new Date()) + e.getMessage());
    e.printStackTrace(logStream);
}