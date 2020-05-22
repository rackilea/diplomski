File someFile = new File("someFile.zip");
File files[] = fc.getSelectedFiles();
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(someFile));

// Create the ZIP file first
try (ZipOutputStream out = new ZipOutputStream(bos)) {
    // Write files/copy to archive
    for (File file : files) {
        // Put a new ZIP entry to output stream for every file
        out.putNextEntry(new ZipEntry(file.getName()));
        Files.copy(file.toPath(), out);
        out.closeEntry();
    }
}