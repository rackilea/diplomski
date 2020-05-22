private BufferedImage autoCorrectBrightnessAndContrast(final BufferedImage image) {
    final int[] histogram = makeHistogram(image);

    if (LOG.isDebugEnabled()) {
        LOG.debug("Histogram: {}", Arrays.toString(histogram));
    }

    final int[] cumulativeHistogram = getCumulativeHistogram(histogram);
    /*
     * Finding the minimum and maximum indices in the histogram where the value at the index is greater than a given
     * threshold, computed from CLIP_PERCENT.
     */
    final int min = getMinIndex(cumulativeHistogram);
    final int max = getMaxIndex(cumulativeHistogram);
    LOG.debug("Min: {} Max: {}", min, max);

    /*
     * alpha is the scaling factor, or the amount that we need to expand the histogram graph horizontally so that it
     * fills the entire width. Essentially increasing contrast.
     */
    double alpha = 1;
    if (max != min) {
        alpha = MAX_COLOR / (double) (max - min);
    }
    /*
     * beta is the translating factor, or the amount that we need to slide the histogram graph left or right so that
     * it lines up with the origin. Essentially adjusting brightness.
     */
    final double beta = -min * alpha;

    return adjustBrightnessAndContrast(image, alpha, beta);
}

/**
 * Creates an int array of length MAX_COLOR representing a histogram from the input image. Each index represents the
 * number of pixels of that greyscale shade in the image.
 * 
 * @param image
 *            the bufferedImage to create a histogram from.
 * @return an int array represenation of the histogram.
 * 
 * @see <a href="https://stackoverflow.com/a/10109389/1088659">Plot a histogram for a buffered image</a>
 */
private static int[] makeHistogram(final BufferedImage image) {
    final int[] histogram = new int[MAX_COLOR];

    final ColorSpace colorSpace = image.getColorModel().getColorSpace();
    LOG.debug("Color space type: {}, is RGB = {}", colorSpace.getType(), colorSpace.isCS_sRGB());

    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            final int color = image.getRGB(x, y);
            final int red =   (color & 0x00ff0000) >> 16;
            final int green = (color & 0x0000ff00) >> 8;
            final int blue =   color & 0x000000ff;
            // Constructing a weighted average of the three color bands
            // based on how much they contribute to the overall brightness
            // of a pixel. (Relative luminance - https://en.wikipedia.org/wiki/Relative_luminance)
            final double greyscaleBrightness = .2126 * red + .7152 * green + .0722 * blue;
            histogram[(int) greyscaleBrightness]++;
        }
    }
    return histogram;
}

/**
 * @param histogram
 * @return an int array representing the cumulative histogram of the given histogram.
 * @see <a href="https://en.wikipedia.org/wiki/Histogram#Cumulative_histogram">Cumulative Histogram</a>
 */
private static int[] getCumulativeHistogram(final int[] histogram) {
    final int[] cumulativeHistogram = new int[histogram.length];

    cumulativeHistogram[0] = histogram[0];
    for (int i = 1; i < histogram.length; i++) {
        cumulativeHistogram[i] = cumulativeHistogram[i - 1] + histogram[i];
    }
    return cumulativeHistogram;
}

/**
 * @param cumulativeHistogram
 * @return the minimum index where the cumulative histogram goes above the threshold set by CLIP_PERCENT.
 */
private static int getMinIndex(final int[] cumulativeHistogram) {
    final int maxValue = cumulativeHistogram[cumulativeHistogram.length - 1];
    final double clipThreshold = CLIP_PERCENT * (maxValue / 100.0) * .5;
    int minIndex = 0;

    while (cumulativeHistogram[minIndex] < clipThreshold) {
        minIndex++;
    }
    return minIndex;
}

/**
 * @param cumulativeHistogram
 * @return the maximum index where the cumulative histogram goes below the threshold set by CLIP_PERCENT.
 */
private static int getMaxIndex(final int[] cumulativeHistogram) {
    final int maxValue = cumulativeHistogram[cumulativeHistogram.length - 1];
    final double clipThreshold = CLIP_PERCENT * (maxValue / 100.0) * .5;
    int maxIndex = cumulativeHistogram.length - 1;

    while (cumulativeHistogram[maxIndex] >= maxValue - clipThreshold) {
        maxIndex--;
    }
    return maxIndex;
}

/**
 * @param image
 * @param alpha
 *            the scaling factor to adjust the contrast.
 * @param beta
 *            the offset factor to adjust the brightness.
 * @return the adjusted image.
 */
private static BufferedImage adjustBrightnessAndContrast(final BufferedImage image, final double alpha, final double beta) {
    BufferedImage processedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
    processedImage = new RescaleOp((float) alpha, (float) beta, null).filter(image, processedImage);
    LOG.debug("alpha: {} beta: {}", (float) alpha, (float) beta);
    return processedImage;
}