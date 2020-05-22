String files[] = root.list(audioFilter);

FilenameFilter audioFilter = new FilenameFilter() {
    File f;
    public boolean accept(File dir, String name) {
    if(name.endsWith(".mp3") || name.endsWith(".MP3")) {
            return true;
        }
        f = new File(dir.getAbsolutePath()+"/"+name);

        return f.isDirectory();
    }
};