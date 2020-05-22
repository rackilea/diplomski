Runtime tr = Runtime.getRuntime();

try {
    Process p = tr.exec("c:\\a.bat");
    InputStream err = p.getErrorStream();
    InputStream std = p.getInputStream();
    //TODO here we go!
} catch (IOException e) {
    e.printStackTrace();
}