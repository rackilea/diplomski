public static void shiftToBlack(BufferedImage img) {
    // the four colors used in test.png, from bright to dark
    List<Integer> colors = Arrays.asList(-196868, -4088073, -10112268, -12500653);
    for (int i = 0; i < img.getRaster().getWidth(); i++) {
        for (int k = 0; k < img.getRaster().getHeight(); k++) {
            int c = img.getRGB(i, k);
            int index = colors.indexOf(c);
            int c2 = index < colors.size() - 1 ? colors.get(index+1) : c;
            img.setRGB(i, k, c2);
        }
    }
}