Widget one;

void setup() {
  one = new Widget(10, 10, 50, 50);
  one.drawWidg();
}
void draw() {
  background(0);
  one.display();
}
void mouseClicked() {
  if (one.isOver()) { 
    println("clicked!");
  }
}




class Widget {
  PGraphics widg;
  PVector wCoord;
  color c = color(255, 0, 0);

  Widget(float x, float y, int w, int h) {
    wCoord = new PVector(x, y);
    widg = createGraphics(w, h);
  }

  void drawWidg() {
    widg.beginDraw();
    widg.background(c);
    widg.endDraw();
  }


  void display() {
    image (widg, wCoord.x, wCoord.y);
  }

  boolean isOver() {
    return mouseX > wCoord.x && mouseX < wCoord.x + widg.width &&
      mouseY > wCoord.y && mouseX < wCoord.y + widg.height;
  }
}