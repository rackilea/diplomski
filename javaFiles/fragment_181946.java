public static void main(String[] args) throws Exception {

    // Create a log directory
    File directoryLogs = new File("logs");
    fileDirectory.mkdirs();

    // Create a log file
    File fileLog = new File(directoryLogs, "log.txt");
    fileLog.createNewFile();

    // Create a stream to to the log file
    FileOutputStream f = new FileOutputStream(fileLog);

    System.setOut(new PrintStream(f));
    System.out.println("This is System class!!!");

    // You should close the stream when the programs end
    f.close();
}