import java.io.*;
  class A
  {
  static int a=5;
    public void turn()
    {
    System.out.println("value of a is"+a);
    }
  }
  class B
  {
    public static void main(String args[])
    {
    int b;
    b=A.a;
    System.out.println("value of a is"+b);
    }
  }