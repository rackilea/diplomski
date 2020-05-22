public abstract class Animal 
{
    public abstract String getAnimalSound();
    public abstract String getAnimalType();

    @Override
    public String toString()
    {
       return "The " + getAnimalType() + " says " + getAnimalSound();
    }
}

public class Duck extends Animal 
{
    @Override
    public String getAnimalSound() 
    {
        return "quacks";
    }

    @Override
    public String getAnimalType() 
    {
        return "Duck";
    }

}

public class Cat extends Animal 
{
    @Override
    public String getAnimalSound() 
    {
        return "meows";
    }

    @Override
    public String getAnimalType() 
    {
        return "Cat";
    }
}


public class Dog extends Animal 
{
    @Override
    public String getAnimalSound() 
    {
        return "barks";
    }

    @Override
    public String getAnimalType() 
    {
        return "Dog";
    }
}