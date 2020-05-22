public File checkFileName(File file) {
    if (!file.getAbsolutePath().toLowerCase().endsWith(".pdf")) {
        return new File(file.getAbsolutePath() + ".pdf");
    } else {
        return file;
    }
}