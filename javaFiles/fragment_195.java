public static class FileKey {
    private File file;
    public FileKey(File file) {
        this.file=file;
    }

    @Override
    public int hashCode() {
        long res = file.length();
        res+=file.lastModified();
        if(file.isHidden())
            res+=2;
        if(file.isDirectory()) {
            res+=3;
        }
        return (int) res;
    }

    @Override
    public boolean equals(Object dst) {
        if(dst instanceof FileKey) {
            int dstHashCode = ((FileKey) dst).hashCode();
            return dstHashCode == this.hashCode();
        }
        return false;
    }
}