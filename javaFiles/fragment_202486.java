public void createPartControl(Composite parent) {
  parent.setLayout(new FillLayout());
  ScrolledComposite scrollBox = new ScrolledComposite(parent, SWT.V_SCROLL);
  scrollBox.setExpandHorizontal(true);
  scrollBox.setExpandVertical(true);

  // Using 0 here ensures the horizontal scroll bar will never appear.  If
  // you want the horizontal bar to appear at some threshold (say 100
  // pixels) then send that value instead.
  scrollBox.setMinWidth(0);

  mParent = new Composite(scrollBox, SWT.NONE);

  FormLayout layout = new FormLayout();
  mParent.setLayout(layout);

  // Adds a bunch of controls here

  mParent.addListener(SWT.Resize, new Listener() {
    int width = -1;
    public void handleEvent(Event e) {
      int newWidth = mParent.getSize().x;
      if (newWidth != width) {
        scrollBox.setMinHeight(mParent.computeSize(newWidth, SWT.DEFAULT).y);
        width = newWidth;
      }
    }
  }

  // Wait until here to set content pane.  This way the resize listener will
  // fire when the scrolled composite first resizes mParent, which in turn
  // computes the minimum height and calls setMinHeight()
  scrollBox.setContent(mParent);
}