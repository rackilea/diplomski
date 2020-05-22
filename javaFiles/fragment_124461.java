public static void main(String[] args) {

    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.open();

    final Composite b = new Composite(shell, SWT.NONE);
    b.setBounds(20, 20, 80, 80);
    b.setBackground(display.getSystemColor(SWT.COLOR_BLUE));

    b.addListener(SWT.MouseDown, new Listener() {

      public void handleEvent(Event e) {

        Tracker tracker = new Tracker(b.getParent(), SWT.RESIZE);
        tracker.setStippled(true);
        Rectangle rect = b.getBounds();
        tracker.setRectangles(new Rectangle[] { rect });
        if (tracker.open()) {
          Rectangle after = tracker.getRectangles()[0];
          b.setBounds(after);
        }
        tracker.dispose();
      }
    });
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }