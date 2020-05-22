public Animal getInstance(String discriminator)
{
    if(discriminator.equals("Dog")) {
         return new Dog();
    }
    // etc.
}