class Pet
{
  Diet diet;

  abstract boolean satisfiesDietRules();

  public Pet()
  {
    if(!satisfiesDietRules())
    {
      throw CannotCreatePetException();
    }
  }
}

class Dog extends Pet
{
  boolean satisfiesDietRules()
  {
    //rules
  }
}