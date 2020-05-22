public static void main(String[] args) throws IOException {
    BufferedImage img = ImageIO.read(new File(args[0]));
    int height = img.getHeight();
    int width = img.getWidth();

    // Create a color model and image in CMYK color space (see custom class below)
    ComponentColorModel cmykModel = new ComponentColorModel(CMYKColorSpace.INSTANCE, false, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);
    BufferedImage cmykImg = new BufferedImage(cmykModel, cmykModel.createCompatibleWritableRaster(width, height), cmykModel.isAlphaPremultiplied(), null);
    WritableRaster cmykRaster = cmykImg.getRaster();

    int R,G,B,pixel;
    float Rc,Gc,Bc,K,C,M,Y;

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            pixel = img.getRGB(x, y);

            // Now, as cmykImg already is in CMYK color space, you could actually just invoke
            //cmykImg.setRGB(x, y, pixel);
            // and the method would perform automatic conversion to the dest color space (CMYK)

            // But, here you go... (I just cleaned up your code a little bit):
            R = (pixel >> 16) & 0xff;
            G = (pixel >> 8) & 0xff;
            B = (pixel) & 0xff;

            Rc = R / 255f;
            Gc = G / 255f;
            Bc = B / 255f;

            // Equations I found on the internet to get CMYK values
            K = 1 - Math.max(Bc, Math.max(Rc, Gc));
            if (K == 1f) {
                // All black (this is where you would get NaN values I think)
                C = M = Y = 0;
            }
            else { 
                C = (1- Rc - K)/(1-K);
                M = (1- Gc - K)/(1-K);
                Y = (1- Bc - K)/(1-K);
            }

            // ...and store the CMYK values (as bytes in 0..255 range) in the raster
            cmykRaster.setDataElements(x, y, new byte[] {(byte) (C * 255), (byte) (M * 255), (byte) (Y * 255), (byte) (K * 255)});
        }
    }

    // You should now have a CMYK buffered image
    System.out.println("cmykImg: " + cmykImg);
}

// A simple and not very accurate CMYK color space
// Full source at https://github.com/haraldk/TwelveMonkeys/blob/master/imageio/imageio-core/src/main/java/com/twelvemonkeys/imageio/color/CMYKColorSpace.java
final static class CMYKColorSpace extends ColorSpace {

    static final ColorSpace INSTANCE = new CMYKColorSpace();

    final ColorSpace sRGB = getInstance(CS_sRGB);

    private CMYKColorSpace() {
        super(ColorSpace.TYPE_CMYK, 4);
    }

    public static ColorSpace getInstance() {
        return INSTANCE;
    }

    public float[] toRGB(float[] colorvalue) {
        return new float[]{
                (1 - colorvalue[0]) * (1 - colorvalue[3]),
                (1 - colorvalue[1]) * (1 - colorvalue[3]),
                (1 - colorvalue[2]) * (1 - colorvalue[3])
        };
    }

    public float[] fromRGB(float[] rgbvalue) {
        // NOTE: This is essentially the same equation you use, except 
        // this is slightly optimized, and values are already in range [0..1]

        // Compute CMY
        float c = 1 - rgbvalue[0];
        float m = 1 - rgbvalue[1];
        float y = 1 - rgbvalue[2];

        // Find K
        float k = Math.min(c, Math.min(m, y));

        // Convert to CMYK values
        return new float[]{(c - k), (m - k), (y - k), k};
    }

    public float[] toCIEXYZ(float[] colorvalue) {
        return sRGB.toCIEXYZ(toRGB(colorvalue));
    }

    public float[] fromCIEXYZ(float[] colorvalue) {
        return sRGB.fromCIEXYZ(fromRGB(colorvalue));
    }
}