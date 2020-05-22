MotifBorders.ButtonBorder newMotifBB = new MotifBorders.ButtonBorder(
    UIManager.getColor("Button.shadow"),        /*shadow*/
    UIManager.getColor("Button.highlight"),         /*highlight*/
    UIManager.getColor("Button.darkShadow"),  /*darkShadow (Originally No defined)*/
    UIManager.getColor("activeCaptionBorder")   /*focus*/) {
  @Override public void paintBorder(
      Component c, Graphics g, int x, int y, int w, int h) {
      //Changes Code
  }
};