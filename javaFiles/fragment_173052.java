BufferedImage im = new BufferedImage(1500,1500,BufferedImage.TYPE_INT_RGB);

private void init() {

    Graphics g = im.getGraphics();

    for(int i = 0; i < mapArray.length; i++){
       for(int j = 0; j < mapArray[1].length; j++){
         //if statement for if its on the screen
         g.drawImage(tiles.get(mapArray[i][j]).getImage(), j * textureSize, i * textureSize, null);

       }
    }
}

public void paintCompoent(Graphics g) {
  super.paintComponent(g);
  g.drawImage(im,0,0,null);
}