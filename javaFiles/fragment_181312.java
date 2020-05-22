File tempFile = File.createTempFile("prefix-", "-suffix");
// e.g.: File tempFile = File.createTempFile("MyAppName-", ".tmp");
tempFile.deleteOnExit();
//get your script and prepare OutputStream to tempFile
// Try with resources, because you want to close your streams
try (InputStream is = ResourceLoader.getScriptResource(scriptName);
     FileOutputStream out = new FileOutputStream(tempFile)) {
    //NOTE: You can use any method to copy InputStream to OutputStream.
    //Here I have used Apache IO Utils
    IOUtils.copy(is, out);
}
boolean success = executePythonScriptWithArgs(tempFile, args);