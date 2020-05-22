// Load the initial page for getting the required cookies
Connection conn = Jsoup.connect("https://www.saes.upiicsa.ipn.mx/");
Document d = conn.get();

Element captcha = d.select("#c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage").first();
if (captcha == null) {
    throw new RuntimeException("Unable to find captcha...");
}

// Fetch the captcha image
Connection.Response response = Jsoup //
        .connect(captcha.absUrl("src")) // Extract image absolute URL
        .cookies(conn.response().cookies()) // Grab cookies
        .ignoreContentType(true) // Needed for fetching image
        .execute();

// Load image from Jsoup response
ImageIcon image = new ImageIcon(ImageIO.read(new ByteArrayInputStream(response.bodyAsBytes())));

// Show image
JOptionPane.showMessageDialog(null, image, "Captcha image", JOptionPane.PLAIN_MESSAGE);