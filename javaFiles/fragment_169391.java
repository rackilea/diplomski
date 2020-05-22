public static void main(String[] args) throws Exception {
    BufferedImage in = ImageIO.read(new File(args[0]));
    int w = in.getWidth(), h = in.getHeight();
    byte[] v = new byte[1 << 4];
    for (int i = 0; i < v.length; ++i)
        v[i] = (byte)(i*17);
    ColorModel cm = new IndexColorModel(4, v.length, v, v, v);
    WritableRaster wr = cm.createCompatibleWritableRaster(w, h);
    BufferedImage out = new BufferedImage(cm, wr, false, null);
    Graphics2D g = out.createGraphics();
    g.drawImage(in, 0, 0, null);
    g.dispose();
    ImageIO.write(out, "png", new File(args[1]));
}