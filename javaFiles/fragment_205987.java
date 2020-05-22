public static void upload(BufferedImage image) {
    String IMGUR_POST_URI = "https://api.imgur.com/3/upload";
    String IMGUR_API_KEY = "Your Client ID";

    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.out.println("Writing image...");
        ImageIO.write(image, "png", baos);
        URL url = new URL(IMGUR_POST_URI);

        System.out.println("Encoding...");
        String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encodeBase64String(baos.toByteArray()).toString(), "UTF-8");
        data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(IMGUR_API_KEY, "UTF-8");

        System.out.println("Connecting...");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Authorization", "Client-ID " + IMGUR_API_KEY);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

        System.out.println("Sending data...");
        wr.write(data);
        wr.flush();

        System.out.println("Finished.");

        //just display the raw response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}