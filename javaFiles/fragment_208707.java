while (fileName.toLowerCase().endsWith(".csv")) {
    fileName = fileName.substring(0, fileName.toLowerCase().lastIndexOf(FILE_SUFFIX_CSV));
    if (fileName.trim().isEmpty()) {
        throw new IllegalArgumentException();
    }
}