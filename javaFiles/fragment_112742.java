BufferedImage bufferedImage;
Graphics2D g2d;

// Manually calculate the bounds
double [] vals = new double[7];

double minX = Double.MAX_VALUE;
double maxX = 0;

double minY = Double.MAX_VALUE;
double maxY = 0;

// Get a path iterator iterating to a certain level of accuracy
PathIterator pi = sn.getOutline().getPathIterator(null, 0.01);

while(!pi.isDone()) {
    pi.currentSegment(vals);

    if(vals[0] < minX ) {
        minX = vals[0];
    }
    if(vals[0] > maxX ) {
        maxX = vals[0];
    }
    if(vals[1] < minY ) {
        minY = vals[1];
    }
    if(vals[1] > maxY ) {
        maxY = vals[1];
    }

    pi.next();
}

sn.setTransform(AffineTransform.getTranslateInstance(-minX, -minY));

bufferedImage = new BufferedImage((int) (maxX - minX), (int) (maxY - minY),
                BufferedImage.TYPE_INT_ARGB);

g2d = (Graphics2D) bufferedImage.getGraphics();

sn.paint(g2d);

ByteArrayOutputStream os = new ByteArrayOutputStream();
ImageIO.write(bufferedImage, "png", os);
InputStream is = new ByteArrayInputStream(os.toByteArray());