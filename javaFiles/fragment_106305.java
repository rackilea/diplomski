// Samples is a 2D int array (int[][]), where the first index is the channel, the second is the sample for that channel
if (samples != null) {

    Graphics2D g2d = (Graphics2D) g;

    int length = samples[0].length;

    int width = getWidth() - 1;
    int height = getHeight() - 1;

    int oldX = 0;
    int oldY = height / 2;
    int frame = 0;

    // min, max is the min/max range of the samples, ie the highest and lowest samples
    int range = max + (min * -2);
    float scale = (float) height / (float) range;

    int minY = Math.round(((height / 2) + (min * scale)));
    int maxY = Math.round(((height / 2) + (max * scale)));

    LinearGradientPaint lgp = new LinearGradientPaint(
            new Point2D.Float(0, minY),
            new Point2D.Float(0, maxY),
            new float[]{0f, 0.5f, 1f},
            new Color[]{Color.BLUE, Color.RED, Color.BLUE});
    g2d.setPaint(lgp);
    for (int sample : samples[0]) {

        if (sample % 64 == 0) {

            int x = Math.round(((float) frame / (float) length) * width);
            int y = Math.round((height / 2) + (sample * scale));

            g2d.drawLine(oldX, oldY, x, y);

            oldX = x;
            oldY = y;

        }

        frame++;

    }

}