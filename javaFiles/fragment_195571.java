float brightenFactor = 1.2f

PlanarImage img=JAI.create("fileload","C:\\aimages\\blue_water.jpg");
BufferedImage image = img.getAsBufferedImage();

RescaleOp op = new RescaleOp(brightenFactor, 0, null);
image = op.filter(image, image);