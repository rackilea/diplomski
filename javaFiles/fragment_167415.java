public Image getImage() {
    if (image == null) {
        log.info("Fetching image: " + imageUri);
        try { 
            URL iURL = new URL(imageUri);
            InputStream is = new BufferedInputStream(iURL.openStream());
            image = ImageIO.read(is);
            height = image.getHeight();
            width = image.getWidth();
        } catch (MalformedURLException e) {
            log.error("Unable to fetch image: " + imageUri, e);
        } catch (IOException e) {
            log.error("Unable to fetch image: " + imageUri, e);
        }
    }
    return image;
}