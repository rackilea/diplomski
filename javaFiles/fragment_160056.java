JFrame f=new JFrame("Disabling via JLayer");
final JLayer<JTree> layer = new JLayer<JTree>(new JTree(), new LayerUI<JTree>() {
  @Override
  public void eventDispatched(AWTEvent e, JLayer<? extends JTree> l) {
    if(e instanceof InputEvent) ((InputEvent)e).consume();
  }
  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
    g2d.dispose();
  }
});
f.setContentPane(layer);
layer.setLayerEventMask(~0);
f.pack();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);