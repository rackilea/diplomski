void getMp3s(File f) {
    File[] files;
    if (f.isDirectory() && (files = f.listFiles()) != null) {
        for (File file : files) {
            getMp3s(file);
        }
    }
    else {
        String path = f.getPath();
        if (path.endsWith(".mp3")) {
            mp3Paths.add(f.getPath());
        }
    }
}