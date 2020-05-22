public static class FileInfo implements Comparable<FileInfo>{
    String key;
    int count; // don't use a wrapper unless you want it to be null.
    long size;

    public FileInfo(String key, File file){
        count = 1;
        this.key = key;
        this.size = file.length();
    }

    public int compareTo(FileInfo other) {
        int cmp = Integer.compare(size, other.size);
        if (cmp == 0)
            cmp = key.compareTo(other.key);
        return cmp;
    }
}