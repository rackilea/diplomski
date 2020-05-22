public class Animal
{
  private String name;
  private boolean legs;
  private boolean eyes;

  public Animal(String name, boolean legs, boolean eyes)
  {
    this.name = name;
    this.legs = legs;
    this.eyes = eyes;
 }
}

public class Dog extends Animal
{
   private boolean vacinated;
   private boolean rabid;
   private Dog(boolean vacinated, boolean rabid, String name, boolean legs, boolean eyes)
    {
      super(name, legs, eyes);
      this.vacinated = vacinated;
      this.rabid = rabid;
  }
}

public class Bulldog extends Dog
{
   private String breedtype;
   public Bulldog(String breedtype, String name, boolean legs, boolean eyes, boolean vacinated, boolean rabid)
   {
    super(vacinated, rabid, name, legs, eyes);
    this.breedtype = breedtype;
  }
}