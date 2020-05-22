public boolean mkdirs() {
    if (exists()) {
        return false;
    }
    if (mkdir()) {
        return true;
    }
    File canonFile = null;
    try {
        canonFile = getCanonicalFile();
    } catch (IOException e) {
        return false;
    }

    File parent = canonFile.getParentFile();
    return (parent != null && (parent.mkdirs() || parent.exists()) &&
            canonFile.mkdir());
}