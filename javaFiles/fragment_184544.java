int[] values = new int[]{0, 32, 64, 96, 128, 160, 192, 224, 255};
SortedMap<Long, Color> colours = new TreeMap<>(Collections.reverseOrder());
for (int r : values) {
    for (int g : values) {
        for (int b : values) {
            long brightness = (r + g + b) / 3;
            long colourScore = (brightness << 24) + (r << 8) + (g << 16) + b;
            colours.put(colourScore, new Color(r,g,b));
        }
    }
}
for (Color color : colours.values()) {
    System.out.println(color);
}