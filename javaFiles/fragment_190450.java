public int print(Graphics g, PageFormat pf, int pageIndex) {
  Component myPanel =...;
  g.translate(pf.getImageableX() + pf.getImageableWidth() / 2 - myPanel.getWidth() / 2, pf.getImageableY() + pf.getImageableHeight() / 2 - myPanel.getHeight() / 2);
  //Graphics object has been set up so the printing myPanel with it should now be centered
  myPanel.print(g);
}