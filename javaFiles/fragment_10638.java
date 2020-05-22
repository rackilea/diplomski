P() {
    MediaTracker mt = new MediaTracker(this);
    bg = Toolkit.getDefaultToolkit().getImage("yourimage");
    mt.addImage(bg, 0);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         int imwidth = bgimage.getWidth(null);
         int imheight = bgimage.getHeight(null);
         g.drawImage(bg, 1, 1, null);
  }
}