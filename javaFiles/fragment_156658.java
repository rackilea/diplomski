interface ClickAction {
  public void clicked();
}

class Button {

  float x;
  float y;
  float width;
  float height;
  ClickAction action;

  public Button(float x, float y, float width, float height, ClickAction action) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.action = action;
  }

  void draw() {
    rect(x, y, width, height);
  }

  void click() {
    action.clicked();
  }
}

ArrayList<Button> buttons = new ArrayList<Button>();

void setup() {

  ClickAction action1 = new ClickAction() {
    public void clicked() {
      println("Clicked button one.");
    }
  };

  ClickAction action2 = new ClickAction() {
    public void clicked() {
      println("Clicked button two.");
    }
  };

  buttons.add(new Button(25, 25, 50, 20, action1));
  buttons.add(new Button(50, 60, 20, 40, action2));
}

void mouseClicked() {
  for (Button b : buttons) {
    if (mouseX > b.x && mouseX < b.x+b.width) {
      if (mouseY > b.y && mouseY < b.y+b.height) {
        b.click();
      }
    }
  }
}

void draw() {
  background(0);

  for (Button b : buttons) {
    b.draw();
  }
}