BufferedImage dest; // input
BufferedImage src; // input

...

byte[] r = new byte[]{(byte)0,(byte)255}; // 255=black, we could set it to some other gray component as desired
byte[] g = new byte[]{(byte)0,(byte)255};
byte[] b = new byte[]{(byte)0,(byte)255};
byte[] a = new byte[]{(byte)255,(byte)0};
IndexColorModel bitmaskColorModel = new IndexColorModel(1, 2, r, g, b, a);

BufferedImage masked = new BufferedImage(bitmaskColorModel, src.getRaster(), false, null);

Graphics2D g = dest.createGraphics();
g.drawImage(masked, transform, null);
g.dispose();