public static Long getFileSize(String path) {
    return getFileSize(new File(path));
}

public static Long getFileSize(File file) {
    return (!file.isFile()) ? -1L : file.length();
}