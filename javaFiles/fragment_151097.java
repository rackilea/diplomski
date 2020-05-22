private static void putDir(Connection conn, String localDirectory, String remoteTargetDirectory, String mode) throws IOException {
    final String[] fileList = curDir.list();
    for (String file : fileList) {
        final String fullFileName = localDirectory + "/" + file;
        if (new File(fullFileName).isDirectory()) {
            final String subDir = remoteTargetDirectory + "/" + file;
            Session sess = conn.openSession();
            sess.execCommand("mkdir " + subDir);
            sess.waitForCondition(ChannelCondition.EOF, 0);
            putDir(conn, fullFileName, subDir, mode);
        }
        else {
            SCPClient scpc = conn.createSCPClient();
            scpc.put(fullFileName, remoteTargetDirectory, mode);
        }
    }
}