public static void writeZipFile(File directoryToZip, List<File> fileList) {
    try {
        //try (FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip")) {
        File path = directoryToZip.getParentFile();
        File zipFile = new File(path, directoryToZip.getName() + ".zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile)) {