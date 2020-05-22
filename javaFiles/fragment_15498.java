private String[] checkDirectories() throws IOException {

    String[] fileFtp = client.listNames();
    String[] fileName = new String[fileFtp.length];
    for (int i=0; i<fileFtp.length; i++) {
        fileName[i] =   fileFtp[i];
    }
    return fileName;
}