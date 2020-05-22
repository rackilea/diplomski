public class PixelsContainer {
    private final int widthInterval = 10;
    private final int minHeight = 10;
    private final int heightInterval = 10;
    private final List<PlotPoint> pixels;

    public PixelsContainer(List<PlotPoint> pixels) {
        this.pixels = Collections.unmodifiableList(pixels);
    }

    public IntStream getFilteredIndexes() {
        Set<Integer> magList = new HashSet<>();
        AtomicInteger pixelStartIndex = new AtomicInteger(0);

        return IntStream.range(1, pixels.size())
                .mapToObj(i -> processIndex(i, magList, pixelStartIndex))
                .filter(OptionalInt::isPresent)
                .mapToInt(OptionalInt::getAsInt);
    }

    private OptionalInt processIndex(int i, Set<Integer> magList, AtomicInteger pixelStartIndexContainer) {
        int pixelStartIndex = pixelStartIndexContainer.get();

        if (getPixelAt(i).getX() - getPixelAt(pixelStartIndex).getX() < widthInterval) {
            int pixelRow = getPixelAt(i).getY() - minHeight / heightInterval;

            if (!magList.add(pixelRow)) {
                return OptionalInt.empty();
            }
        } else {
            pixelStartIndexContainer.set(i);
            magList.clear();
        }

        return OptionalInt.of(i);
    }

    private PlotPoint getPixelAt(int i) {
        return pixels.get(i);
    }
}