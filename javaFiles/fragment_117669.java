public class LegacyPixelsContainer {
    private final int widthInterval = 10;
    private final int minHeight = 10;
    private final int heightInterval = 10;
    private final List<PlotPoint> pixels;

    public LegacyPixelsContainer(List<PlotPoint> pixels) {
        this.pixels = Collections.unmodifiableList(pixels);
    }

    public List<Integer> getFilteredIndexes() {
        List<Integer> indexResults = new ArrayList<>(pixels.size());
        HashSet<Integer> magList = new HashSet<>();
        int pixelStartIndex = 0;

        for (int i = 1; i < pixels.size(); i++) {
            if (getPixelAt(i).getX() - getPixelAt(pixelStartIndex).getX() < widthInterval) {
                int pixelRow = getPixelAt(i).getY() - minHeight / heightInterval;

                if (!magList.add(pixelRow)) {
                    continue;
                }
            } else {
                pixelStartIndex = i;
                magList.clear();
            }

            indexResults.add(i);
        }

        return indexResults;
    }

    private PlotPoint getPixelAt(int i) {
        return pixels.get(i);
    }
}