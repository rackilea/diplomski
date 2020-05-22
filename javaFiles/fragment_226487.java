@Override
public Dimension getPreferredScrollableViewportSize() {
  System.out.println(getName()
        + " getPreferredScrollableViewportSize called");
  StackTraceElement[] foo = Thread.currentThread().getStackTrace();
  int maxTraces = 10;
  for (int i = 0; i < foo.length && i < maxTraces ; i++) {
     System.out.printf("%02d: %s%n", i, foo[i]);
  }
  if (getComponentCount() > 0) {
     Component[] comps = getComponents();
     int height = ROW_COUNT * comps[0].getPreferredSize().height;
     return new Dimension(VP_WIDTH, height);
  }

  return super.getPreferredSize();
}