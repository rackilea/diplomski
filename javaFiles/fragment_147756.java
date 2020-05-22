final String urlStr = "http://www.earthtimes.org/newsimage/osteoderms-storing-minerals-helped-huge-dinosaurs-survive_3011.jpg";
final URL url = new URL(urlStr);
final HttpURLConnection connection = (HttpURLConnection) url
        .openConnection();
connection.setRequestProperty(
    "User-Agent",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
final BufferedImage image = ImageIO.read(connection.getInputStream());