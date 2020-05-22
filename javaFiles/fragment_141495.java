final Graphics2D g = (Graphics2D)graphComponent.getGraphics();
Runnable r = new Runnable() {
   public void run() {
      g.setColor(Color.BLACK);
      g.drawLine(0, 0, 500, 500);
   }
};

if (!SwingUtilities.isEventDispatchThread()) {
    SwingUtilities.invokeLater(r);
} else {
    r.run();
}