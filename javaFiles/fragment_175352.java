abstract class Human
{
  private String name;
  public Human (String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return name;
      }
  public void eat()
  {
    System.out.println(name + " went to fridge.");
  }
  public abstract void goPee();
}