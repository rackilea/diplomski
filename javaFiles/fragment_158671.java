import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;

/**
 * Wrapper for java.awt.Frame that wraps the contents in a Panel.  This is done
 * because Frames in OS X appear to ignore the background color, but if the
 * contents are wrapped in a Panel and that Panel is given the background color
 * then it works fine.
 */
public class FrameW extends Frame {

  private Panel wrapper;

  /** Constructs the Frame wrapper */
  public FrameW() {
    super();
    init();
  }

  /**
   * Constructs the Frame wrapper.
   * @param title The title to give the frame.
   */
  public FrameW(String title) {
    super(title);
    init();
  }

  public Component add(Component comp) {
    return wrapper.add(comp);
  }

  public Component add(String name, Component comp) {
    return wrapper.add(name, comp);
  }

  public Component add(Component comp, int index) {
    return wrapper.add(comp, index);
  }

  public void add(Component comp, Object constraints) {
    wrapper.add(comp, constraints);
  }

  public void add(Component comp, Object constraints, int index) {
    wrapper.add(comp, constraints, index);
  }

  public LayoutManager getLayout() {
    return wrapper.getLayout();
  }

  public void setLayout(LayoutManager mgr) {
    /* setLayout is called by Frame's constructor before our init runs. */
    if(this.wrapper == null) { return; }
    wrapper.setLayout(mgr);
  }

  public void setBackground(Color c) {
    super.setBackground(c);
    wrapper.setBackground(c);
  }

  /**
   * Overriding the insets of the frame will cause the panel used for the
   * background color to not take up the entire frame's area.  Instead, override
   * FrameW.getContentInsets() for setting the insets of the content.
   * @return The frame's insets
   */
  public Insets getInsets() {
    return super.getInsets();
  }

  /**
   * Override this instead of getInsets() in order to set the insets of the
   * FrameW.
   * @return The insets for the content
   */
  public Insets getContentInsets() {
    return new Insets(0, 0, 0, 0);
  }

  private void init() {
    this.wrapper = new Panel() {
      public Insets getInsets() {
        return FrameW.this.getContentInsets();
      }
    };

    super.setLayout(new BorderLayout());
    super.add(this.wrapper, BorderLayout.CENTER);
  }
}