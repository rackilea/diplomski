class Foobar {
  private List<Car> cars;
  public Foobar() {
    // create your cars, put them in the list
  }

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    for (Car car : cars) {
      g2d.setColor(car.color);
      g2d.fill(car.rect);
    }
  }
}

class Car {
  Rectangle rect;
  Color color;
  // constructors etc.
}