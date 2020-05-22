public class TransparentWindow extends JWindow {

public TransparentWindow(Window owner) {
    this(owner, WindowUtils.getAlphaCompatibleGraphicsConfiguration());
  }

  private TransparentWindow(Window owner, GraphicsConfiguration graphicsConfiguration) {
    super(owner, graphicsConfiguration);
  }
....
}