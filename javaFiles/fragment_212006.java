public static BufferedImage deepCopyImage(BufferedImage bF){
        ColorModel cm = bF.getColorModel();
        boolean alphaPre = bF.isAlphaPremultiplied();
        WritableRaster wR = bF.copyData(null);
        return new BufferedImage(cm, wR, alphaPre, null);
    }