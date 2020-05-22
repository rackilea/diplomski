public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
    URL url  = new URL("http://cdn.portableapps.com/GoogleChromePortable_128.png");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    InputStream is = conn.getInputStream();


      BufferedImage image = ImageIO.read(is);
      OutputStream os = new FileOutputStream(new File("output.png"));
      ImageIO.write(image, "png", os);
}