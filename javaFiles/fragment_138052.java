File dstFile = null;
// check the directory for existence.
String dstFolder = LOCAL_FILE.substring(0,LOCAL_FILE.lastIndexOf(File.separator));
if(!(dstFolder.endsWith(File.separator) || dstFolder.endsWith("/")))
    dstFolder += File.separator;

// Creates the destination folder if doesn't not exists
dstFile = new File(dstFolder);
if (!dstFile.exists()) {
    dstFile.mkdirs();
}
try {
    URL url = new URL(URL_LOCATION);
    FileUtils.copyURLToFile(url, dstFile);
} catch (Exception e) {
    System.err.println(e);
    VeBLogger.getInstance().log( e.getMessage());
}