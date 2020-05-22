Runtime runtime = Runtime.getRuntime();
try {
    String path = "/path/to/firefox";
    Process process = runtime.exec(path + " " + url);
} catch (IOException e) {
    // ...
}