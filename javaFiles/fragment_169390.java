public static void main(String[] args) throws Exception {
    BufferedImage in = ImageIO.read(new File(args[0]));
    int w = in.getWidth(), h = in.getHeight();
    int[] bits = { 4 };
    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
    int dt = DataBuffer.TYPE_BYTE;
    ColorModel cm = new ComponentColorModel
        (cs, bits, false, false, Transparency.OPAQUE, dt);
    WritableRaster wr = cm.createCompatibleWritableRaster(w, h);
    BufferedImage out = new BufferedImage(cm, wr, false, null);
    Graphics2D g = out.createGraphics();
    g.drawImage(in, 0, 0, null);
    g.dispose();
    ImageIO.write(out, "png", new File(args[1]));
}