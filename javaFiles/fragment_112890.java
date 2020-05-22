public static void doInBackground(Elements links) throws IOException {
    try {
        for (Element element : links) {
            //Connect to the first link
            Document doc = Jsoup.connect(element.attr("abs:href")).get();

            //Select all the elements with ID 'strip'
            Elements img = doc.select("#strip");

            //Get the source of the image
            String imgSrc = img.attr("abs:src");

            //Open an InputStream
            InputStream input = new java.net.URL(imgSrc).openStream();
            //Get the image
            bitmap = BitmapFactory.decodeStream(input);
            ...
            //Perhaps save the image somewhere?

            //Close the InputStream
            input.close();
        }
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    } catch (MalformedURLException ex) {
        System.out.println(ex.getMessage());
    }
}