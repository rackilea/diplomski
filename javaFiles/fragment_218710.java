public File getFile(String url) {
    String filename = String.valueOf(url.hashCode());
    // String filename = URLEncoder.encode(url);
    File f = new File(cacheDir, filename);
    f.createNewFile();
    return f;
}