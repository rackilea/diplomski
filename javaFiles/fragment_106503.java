for (int wallsX = 0; wallsX < 750; wallsX += 95) {
      for (int wallsY = 0; wallsY < 750; wallsY += 95) {
           shapeList.add(new Rectangle(wallsX, wallsY, 95, 95));
           g.setColor(Color.blue);
           g.drawRect(wallsX, wallsY, 95, 95);
      }
}