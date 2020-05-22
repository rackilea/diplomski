paintComponent(Graphics g) {
  int x = 0;
  int y = 0;
  int w = worldMap[0][0].getWidth();
  int h = worldMap[0][0].getHeight();
  for(int r=0; r<WorldMap.length; r++) {
    for(int c=0; c<WorldMap[r].length; c++) {
      g.drawImage(WorldMap[r][c], x, y, this);
      x += w;  
    }
    y += h;
    x = 0;
  }
}