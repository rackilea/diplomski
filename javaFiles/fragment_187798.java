public static class Bidriectional extends BasicArrowButton {
  private static final long serialVersionUID = 1L;

  public Bidriectional() {
   // This does not matter, we'll override it anyways.
   super(SwingConstants.NORTH);
  }

  @Override
  public void paintTriangle(Graphics g, int x, int y, int size,
    int direction, boolean isEnabled) {

   super.paintTriangle(g, x - (size / 2), y, size, SwingConstants.EAST, isEnabled);
   super.paintTriangle(g, x + (size / 2), y, size, SwingConstants.EAST, isEnabled);
  }
 }