class A
{
  private static int your_var = 0;

  public int get()
  {
     return your_var;
  }
  public void set(int a)
  {
      your_var = a;
  }
}

 class B extends A
  {

  }

  class C extends A
  {

  }