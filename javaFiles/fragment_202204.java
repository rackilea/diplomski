public static void saveImage(String imageUrl, File folder, String m) throws IOException {
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("si quedo con el if folderpath----" + folder);
        }
        URL url = new URL(imageUrl);
        //String destName = folder;
        //System.out.println(destName);
        m = m + ".jpg";
        //final URL url = new URL(urlStr);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        final BufferedImage image = ImageIO.read(connection.getInputStream());
        ImageIO.write(image, "jpg", new File(m));
    }