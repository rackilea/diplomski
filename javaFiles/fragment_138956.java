abstract class Renderer {
  boolean isPointVisible(int x, int y);
}

class SimpleRenderer {
  @Override
  public boolean isPointVisible(int x, int y) {
    return true;
  }
}

class ComplexRenderer {
  @Override
  public boolean isPointVisible(int x, int y) {
    return x > 0 && x < 100 && y < 0 && y < 100;
  }
}