public abstract class Animal
{
   private String name;
   private int age;

   public Animal(String nam)
   {
      name = nam;
   }

   public void displayName() 
   {
      System.out.println("This animal is: " + name);
   }

   public abstract int getAgeInAnimalYears();
}

public class Cat extends Animal
{
       private int age;

       public Cat(String nam, int a)
       {
          super(nam);
          age = a;
       }

       @Override
       public int getAgeInAnimalYears()
       {
           return age * 9;
       }
}

public class Dog extends Animal
{
       private int age;

       public Dog(String nam)
       {
          super(nam)
          age = 15;
       }

       @Override
       public int getAgeInAnimalYears()
       {
           return age * 7;
       }
}