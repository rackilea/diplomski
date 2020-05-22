public static void backupDb(final String mysqlDumpFilePath)
    throws IOException, InterruptedException {

    String folderPath = mysqlDumpFilePath.substring(0, mysqlDumpFilePath.lastIndexOf("\\"));
    File folder = new File(folderPath);
    if (!folder.exists()) {
        folder.mkdirs(); // 2
    }
    File f = new File(mysqlDumpFilePath);
    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "C:\\\"Program Files\"\\MySQL\\\"MySQL Server 5.5\"\\bin\\mysqldump -u root -pmypass mydb > "
        + f.getAbsolutePath()); //1 & 3

    Process exec = builder.start();
    int retCode = exec.waitFor();
    if (retCode != 0) { //4
        // something went wrong
        InputStream errorStream = exec.getErrorStream();
        byte[] buffer = new byte[errorStream.available()];
        errorStream.read(buffer);

        System.out.println(new String(buffer));
    }

}