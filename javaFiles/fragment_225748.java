try (OutputStream outputStream1 = new BufferedOutputStream(
            new FileOutputStream(downloadFile1))) {
    boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
    if (success) {
        System.out.println("File #1 has been downloaded successfully.");
    }
}