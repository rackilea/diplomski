private void setImage(RasterImage image) {
  try {
     int bpp = image.getBitsPerPixel();
     RasterByteOrder order = image.getOrder();
     Bitmap newpic=RasterImageConverter.convertToBitmap(image, ConvertToImageOptions.NONE.getValue());

     newpic = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Config.ARGB_8888);
     Canvas c = new Canvas(newpic);
     c = new Canvas(newpic);
     mViewer.draw(c);
     Paint p = new Paint();
     p.setColor(0xFFFF0000);
     c.drawLine(20, 20, 200, 200, p);

     mViewer.setImageBitmap(newpic);
  } catch(Exception ex) {
     Messager.showError(this, ex.getMessage(), "");
  }
}