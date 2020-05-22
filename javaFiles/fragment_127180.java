public static boolean canMkdirs(File dir) {
    if(dir == null || dir.exists())
        return false;
    File parent = null;
    try {
        parent = dir.getCanonicalFile().getParentFile();
        while(!parent.exists())
            parent = parent.getParentFile();
    } catch(NullPointerException | IOException e) {
        return false;
    }
    return parent.isDirectory() && parent.canWrite();
}