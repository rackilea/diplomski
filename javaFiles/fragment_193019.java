class LocalMinMax {

    static double[] pts;
    static int visiblePoints = 5000;
    static int startX = 200;
    static int endX = 700;

    public static void main(String[] args) {
        int lastX2 = 0;
        int maxWidth = 800;
        double hstep = maxWidth / (double) visiblePoints;
        int maxHeight = 400;
        pts = new double[visiblePoints];
        for (int i = 0; i < pts.length; i++) {
            pts[i] = (((Math.sin(.009 * i)) * (Math.cos(.004 * i)))
                * (maxHeight / 3d) * .95) + (maxHeight / 2d);
        }
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < visiblePoints; i++) {
            int x2 = (int) (i * hstep);
            if (x2 >= startX) {
                int sectionStartIndex = i;
                int sectionEndIndex = (int) (endX / hstep);
                for (int k = sectionStartIndex; k < sectionEndIndex; k++) {
                    if (min > pts[k]) {
                        min = pts[k];
                        minIndex = x2;
                      //System.out.println("minIndex, min, pts[" + k + "], x2: "
                      //+ minIndex + ", " + min + ", " + pts[k] + ", " + x2);
                    }
                    if (max < pts[k]) {
                        max = pts[k];
                        maxIndex = x2;
                      //System.out.println("maxIndex, max, pts[" + k + "], x2: "
                      //+ maxIndex + ", " + max + ", " + pts[k] + ", " + x2);
                    }
                }
            }
            if (lastX2 != x2) {
                lastX2 = x2;
                if (x2 == startX) {
                    int width = endX - startX;
                }
            }
        }
        int maxVal = (int) max;
        int minVal = (int) min;
        System.out.println("Local: maxIndex, maxVal: " + maxIndex + ", " + maxVal);
        System.out.println("Local: minIndex, minVal: " + minIndex + ", " + minVal);
    }
}