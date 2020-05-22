public static void main(String args[]) throws IOException, URISyntaxException {
    URI uri = new URI(
            "http",
            "52.66.123.140:8080",
            "/TATADHPFILES/1239/TDH Items/149387773752120170504_113201.jpg",
            "Implementation", "Java");
    URL url = uri.toURL();

    try {
        BufferedImage img = ImageIO.read(url);

        // --- your original code will also now work ---
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        // ---------------------------------------

        System.out.println("tester");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}