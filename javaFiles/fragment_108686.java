public static boolean writeToFile(String path, String fname) {
    File file = new File(path, fname);
    try (FileOutputStream stream = new FileOutputStream(file)) {
        stream.write(tosave.getBytes());
    } catch (IOException e) {
        // Should probably log the exception too
        return false;
    }
    return true;
}