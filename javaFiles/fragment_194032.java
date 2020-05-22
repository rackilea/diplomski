class Pet<T extends Talker>
{
    private T pet;

    public Pet(T pet)
    {
        this.pet = pet;
    }

    public String talks()
    {
        return pet.talks(); // is now defined for type T
    }
}

interface Talker
{
    String talks();
}