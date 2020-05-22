public class MyClass
{ 

  // these are Class variables, they are tied to the Class
  // and shared by all instances of the class.
  // They are referenced like MyClass.X
  // By convention all static variables are all UPPER_CASE
  private static int X;
  private static int Y

  // these are instance variables that are tied to 
  // instances of the class
  private int a;
  private int b;

  /** this the default no arg constructor */
  public MyClass() { this.a = 5; this.b = 10; }

  /** this is a Constructor that lets you set the starting values
      for each instance */
  public MyClass(final int a, final int b) { this.a = a; this.b = b; }

  public modifyNow() { this.a++; this.b++; }

  /** this is an accessor to retrieve the value of a */
  public int getA() { return this.a; }

  public int getB() { return this.b; }
 }

 final MyClass myInstanceA = new MyClass();
 myInstance.modifyNow();
 // a = 6, b = 11

 final MyClass myInstanceB = new MyClass(1, 2);
 myInstance.modifyNow();
 // a = 2, b = 3