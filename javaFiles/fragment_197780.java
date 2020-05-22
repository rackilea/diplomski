public List<File> getMP3Files(String directory) {
    List<File> files = new ArrayList<File>();
    File folder = new File(directory);
    for (File file : folder.listFiles()) {
        if (file.isFile()) {
            if (file.getName().endsWith(".mp3") || file.getName().endsWith(".MP3")) {
                files.add(file);
            }
        }
    }
    return files;
}