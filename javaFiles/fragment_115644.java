private String createHtmlLauncher(String targetUrl) throws Exception {          
    String launcherFile = System.getProperty("java.io.tmpdir") + "local_launcher.html";
    File launcherTempFile = new File(launcherFile);         
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(launcherTempFile, "UTF-8");
    } catch (Exception e) {
        throw new Exception("Error opening file for writing: " + launcherTempFile.getAbsolutePath() + " : " + e.getMessage());
    }
    writer.println("<meta http-equiv=\"refresh\" content=\"0; url=" + targetUrl + "\" />");
    writer.close();

    return "file:///" + launcherFile.replace("\\", "/");        
}