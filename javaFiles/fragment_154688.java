public static abstract class Triangle {
      private double side;
      public abstract double getArea();
      public abstract double getPerimeter();
      public double getRatio() {
        return getArea() / getPerimeter();
      }
      public Triangle(double side) {
        this.side = side;
      }

      protected double getSide()
      {
          return this.side;
      }

    @Override
    public String toString() {
        return "Triangle: SideLen = " + this.side 
          + " || Area = " + getArea()
          + " || Perimeter = " + getPerimeter()
          + " || Ratio = " + getRatio();
    }
 }