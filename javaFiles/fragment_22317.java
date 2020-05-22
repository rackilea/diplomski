public interface Animal {}

public class Zoo {
  private final SetMultimap<Class<? extends Animal>, Animal> animals;

  public Zoo() {
    animals = LinkedHashMultimap.create();
  }

  public void addAnimal(Animal animal) {
    animals.put(animal.getClass(), animal);
  }

  @SuppressWarnings("unchecked") // the cast is safe
  public <T extends Animal> Set<T> getAnimals(Class<T> species) {
    return (Set<T>) animals.get(species);
  }
}