Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\mogen\\Pictures\\importImage\\explosion.gif");
if (elapsedTimeMsec >= 5200 && elapsedTimeMsec < 6100){

  g.drawImage(image, 750, 425, null);
}else{
  g.drawImage(image, 0, 0, null);
}