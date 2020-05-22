BufferedImage bi = new BufferedImage(5,5,BufferedImage.TYPE_INT_ARGB);
Graphics2D g = (Graphics2D) bi.getGraphics();
while(i < 25){
  g.setColor(new Color(See Api for more details on how to create a Color);
  g.drawRect(i/5, i%5, 1,1);
}