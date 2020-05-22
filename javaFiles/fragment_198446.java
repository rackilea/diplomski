int prevX, prevY;

public void render() {
  BufferStrategy bs = this.getBufferStrategy();
  if (bs == null) {
      createBufferStrategy(3);
      return;
  }
  Graphics g = bs.getDrawGraphics();

  // erase the previous square
  g.setColor(getBackground());
  g.fillRect(prevX, prevY, 300, 300);

  // draw the new square
  g.setColor(Color.CYAN);
  g.fillRect(x, y, 300, 300);

  g.dispose();
  bs.show();
}

public void tick() {
  // backup the previous coordinates
  prevX = x;
  prevY = y;

  x += velx;
  y += vely;
}