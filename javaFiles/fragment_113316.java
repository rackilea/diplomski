import processing.core.*;

public class MyClass implements PConstants {

  PApplet parent;
  private int backgroundColour = 0;

  public MyClass (PApplet parent) {
    this.parent = parent;
    parent.registerMethod("draw", this);
  }

  public void draw() {
    parent.background(backgroundColour++, 0, 0);
    parent.println(backgroundColour);
  }
}