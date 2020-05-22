public class Complex 
{
  private double x;
  private double y;

  public Complex(double x , double y)
  {
    this.x = x;
    this.y = y;
  }

  public Complex add (Complex c) 
  {
    Complex sum = new Complex();
    sum.x = this.x + c.x;
    sum.y = this.y + c.y;
    return sum;
  }

}

public static void main(String args[])
{
  Complex p1 = new Complex(1 , 2); 
  Complex p2 = new Complex(3 , 4); 
  Complex p3 = p2.add(p1); 
}