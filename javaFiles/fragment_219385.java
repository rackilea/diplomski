class MyFrame extends JFrame {
   public static final int MAX_WIDTH = 0x400;
   public static final int MAX_HEIGHT = 0x300;

   @Override
   public Dimension getPreferredSize() {
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension screenSize = toolkit.getScreenSize();
      int maxWidth = Math.min(screenSize.width, MAX_WIDTH);
      int maxHeight = Math.min(screenSize.height, MAX_HEIGHT);

      return new Dimension(maxWidth, maxHeight);
   }
}