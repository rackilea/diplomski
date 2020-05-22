FileOutputStream output = new FileOutputStream(file);
try {
    IOUtils.copy(videoData, output);
} finally {
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(videoData);
}