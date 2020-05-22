public void paint(Graphics g) {
    if (doubleBuffer) {
      paintSky(top.gBuf);
      g.drawImage(top.buf, 0, 0, this);
    } else {
      paintSky(g);
    }
  }