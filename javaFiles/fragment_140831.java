public class TestRect {

  private double base;
  private double height;
  private double area;
  private double perimeter;

  public TestRect (double base, double height) {
     this.base = base;
     this.height = height;
     getPerimeter;
     getArea;
  }

  public double getPerimeter () {
     perimeter = 2 * (base + height);
     return perimeter;
  }

  public double getArea () {
     area = (base * height);
     return area;
  }

  @Override
  public String toString() {
     // TODO Auto-generated method stub
     // here you can create a string just as you want it to look like
     return yourCreatedString;
  }

  public static void main(String[] args) {

      TestRect test = new TestRect(3.0, 4.0);
      System.out.println(test.toString());
   }

}