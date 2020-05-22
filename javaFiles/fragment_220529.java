public abstract class BasePanel extends JPanel {

...    

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);       
    provideCustomPainting(g);
  }   

  protected void provideCustomPainting(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

    this.standardDraw(drawObjects,g2);
  }
}

public class AspectRatioPanel extends BasePanel {
  protected void provideCustomPainting(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

    // Get ViewPort Bounding Box to clip
    BoundingBox viewPortBoundingBox = this.getViewPortBoundingBox();

    // Clip to viewport
    g2.setClip((int)viewPortBoundingBox.topLeft.getX(),(int)viewPortBoundingBox.topLeft.getY(),(int)viewPortBoundingBox.getWidth(),(int)viewPortBoundingBox.getHeight());

    this.standardDraw(drawObjectsBuf,g2);
  }
}