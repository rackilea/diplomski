public static void openContaiingFolder(File file) {
    String absoluteFilePath = file.getAbsolutePath();
    File folder = new File(absoluteFilePath.substring(0, absoluteFilePath.lastIndexOf(File.separator)));
    openFolder(folder);
}

public static void openFolder(File folder) {
    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().open(folder);
    }
}