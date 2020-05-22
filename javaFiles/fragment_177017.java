class Class1
{
  String number;
  public String getnumber()
  {
    return this.number;
  }
}

class Class2
{
  Class1 cla; 
  public String number_to_compute;

  public Class2()
  {
    cla = new Class1();
    cla.number = "1";
    number_to_compute = cla.getnumber();
  }
}

class Class3
{
  Class1 class1;
  Class2 class2;

  public Class3()
  {
    class1 = new Class1();
    class1.number = "2";
    class2 = new Class2();
  }

  public static void main(String args[])
  {
    Class3 cl = new Class3();
    System.out.println(cl.class2.cla.getnumber()); 
    System.out.println(cl.class2.number_to_compute);
  }
}