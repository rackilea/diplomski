public class Animal
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

   public int getAgeInAnimalYears() {
      throw new UnsupportedOperationException();
   }
}