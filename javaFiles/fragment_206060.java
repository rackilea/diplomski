try {
    Runtime runTime = Runtime.getRuntime();
    // Don't forget that '\' needs to be escaped with another '\'
    // Also, there may be spaces in the name(s). Use quotes (with their own escapes!)
    Process process = runTime.exec("\"C:\\Windows\\system32\\notepad.exe\"" +
                                   " " +    // Separate argument with space
                                   "\""+document.getAbsolutePath()+"\"");
} // try
catch (IOException e) {
    e.printStackTrace();
} // catch