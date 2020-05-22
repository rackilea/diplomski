public class Zoo
{
    private ArrayList<Animal> list = new ArrayList<Animal>();

    public void addAnimal(Animal a)
    {
        list.add(a);
    }

    public void everyoneSayHello()
    {
        for (Animal a : list) {
            a.displayName();
            System.out.println("It is " + a.getAgeInAnimalYears() + \
                               " animal-years old!")
        }
    }
 }