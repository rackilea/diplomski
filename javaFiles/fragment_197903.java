private void copyFile(Path source, Path dest) {
    try {
        Files.copy(source, dest);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}