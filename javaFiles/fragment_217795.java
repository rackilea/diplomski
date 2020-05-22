public static void drawHistogram(double[] array) {

    StringBuilder histoGram[] = new StringBuilder[11];
    for (int i = 0; i < histoGram.length; i++) {
        histoGram[i] = new StringBuilder();
    }

    for (int i = 0; i < array.length; i++) {
        int bracket = (int) Math.floor(array[i]);
        if (bracket >= 0 && bracket < histoGram.length) {
            histoGram[bracket].append("*");
        }
    }
    for (int j = 0; j < 11; j++) {
        System.out.format("%02d: %s\n", j, histoGram[j].toString());
    }
}