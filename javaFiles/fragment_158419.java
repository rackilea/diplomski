{
    BufferedImage old = image;
    image = new BufferedImage(
        old.getWidth(),
        old.getHeight(),
        BufferedImage.TYPE_INT_RGB
    );
    image.setData(old.getRaster());
} // old is no longer needed