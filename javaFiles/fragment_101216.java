int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth())) {
for (int i = 0; i < pixels.length; i++) {
    if (Array.equals(search, Array.copyOfRange(pixels, i, i + search.length)) {
        //found it
    }
}