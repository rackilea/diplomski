class Computer
{

  public static void main(String[] args)
  {
      Computer computer = new Computer();
      computer.method();

      // Instantiate normal inner class from instance object.
      Laptop laptop = computer.new Laptop(); // Or: new Computer().new Laptop();
      laptop.method();

      // Instantiate static inner class directly.
      StaticLaptop staticLaptop = new StaticLaptop();
      staticLaptop.method();
  }

  void method()    
  {
      System.out.println("I'm Computer!");
  }


  class Laptop
  {
      void method()
      {
        System.out.println("I'm Laptop!");  
      }
  }

  static class StaticLaptop
  {
      void method()
      {
        System.out.println("I'm StaticLaptop!");  
      }
  }

}