public class JHorizontalFriendlyTable extends JTable {

  @Override
  public Dimension getPreferredSize() {
    if (getParent () instanceof JViewport) {
      if (
        ((JViewport) getParent()).getWidth() > super.getPreferredSize().width)
      ) {
        return getMinimumSize();
      }
    }
    return super.getPreferredSize(); 
  }

  @Override
  public boolean getScrollableTracksViewportWidth () {
    if (autoResizeMode != AUTO_RESIZE_OFF) {
      if (getParent() instanceof JViewport) {
        return (((JViewport) getParent()).getWidth() > getPreferredSize().width);
      }
      return true;
    }
    return false;
  }
}