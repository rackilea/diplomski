Image createImage(String url)
throws IOException {
    URLConnection conn = new URL(url).openConnection();
    conn.setRequestProperty("User-Agent", "Wget/1.13.4 (linux-gnu)");

    try (InputStream stream = conn.getInputStream()) {
        return new Image(stream);
    }
}