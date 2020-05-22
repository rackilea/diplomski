public enum ImagePool {
    INSTANCE;

    private Map<String, Image> images;

    private ImagePool() {
        images = new HashMap<>(25);
    }

    public synchronized Image grab(String name) throws IOException {
        Image image = images.get(name);
        if (image == null) {
            image = ImageIO.read(new File(name));
            images.put(name, image);
        }
        return image;
    }

}