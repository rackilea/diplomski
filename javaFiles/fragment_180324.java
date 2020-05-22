display_parent = new Canvas() {
    public final void addNotify() {
       super.addNotify();
       startLWJGL();
    }
    public final void removeNotify() {
      stopLWJGL();
      super.removeNotify();
    }
 };
 frame.add(display.parent);