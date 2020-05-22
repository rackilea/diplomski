public static String getRFTVersionWithRegexp() {
    File versionFolder = new File(RFTVersionFolder);
    File[] versionFile = versionFolder.listFiles( new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".swtag"));
        } } );

    byte[] buffer = null;
    FileInputStream fin;
    try {
        fin = new FileInputStream(versionFile[0]);
        buffer = new byte[(int) versionFile[0].length()];
        new DataInputStream(fin).readFully(buffer);
        fin.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } 
    String versionFileContent = new String(buffer);
    String version = null;
    Regex r = new Regex("[0-9]\\.[0-9]\\.[0-9]", Regex.MATCH_NORMAL);
    if (r.matches(versionFileContent))
        version = r.getMatch();

    return version;
}