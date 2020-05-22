class ScreenContent {

    // ...

    GammaCorrector gammaCorrector = new GammaCorrector();

    // ...

    int[][] image;

    void correctGamma() {
        for (int[] row : image) {
            for (int i = 0; i &lt; row.length; i++) {
                row[i] = gammaCorrector.correct(row[i], gamma);
            }
        }
    }
}

class GammaCorrector {
    private int[] unpacked = new int[4];

    public int correct(int pixel, float gamma) {
        float ginv = 1 / gamma;
        ColorUtils.unpackInt(pixel, ColorUtils.TYPE_ARGB, unpacked);
        for(int i = 0; i &lt; rgbVals.length; i++) {
            rgbVals[i] = (int) Math.round(255 - Math.pow(unpacked[i] / 255.0, ginv));
        }
        return ColorUtils.packInt(unpacked);
    }
}