BufferedWriter bw;
boolean isOpen = false;
// ..
try {
    if (!isOpen) {
        bw = new BufferedWriter(new FileWriter(logFile, true));
        bw.write(firstLine);
        isOpen = true;
    }
    bw.write(string);
    bw.flush();
    Log.v("file", "written to file:" + logFile.getAbsolutePath());
} catch (IOException e) {
    Log.v("IOException", e.toString());
}