if (file.exists()) {
    file.delete();
    file.createNewFile();
} else {
    file.mkdirs();
    file.createNewFile();
}