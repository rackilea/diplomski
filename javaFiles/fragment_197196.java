public static class FileInfo implements Comparable<FileInfo>{
    final String key;
    final int count; // don't use a wrapper unless you want it to be null.
    final long size;

    public FileInfo(String key, File file){
        count = 1;
        this.key = key;
        this.size = file.length();
    }
    public String getKey() { return key; }
    public long getSize() { return size; }
    public String toString() { return key + ' ' + size + ' ' + count; }
}


exts.values().stream()
              .sort(comparing(FileInfo::getSize).andThen(FileInfo::getKey))
              .forEach(System.out::println);