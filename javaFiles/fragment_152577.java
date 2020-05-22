import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Enclosure {
    private final List<Animal> animals = new LinkedList<>();

    public void add(final Animal animal) {
        this.animals.add(animal);
    }

    public Set<Class<? extends Animal>> getSpecies() {
        final Set<Class<? extends Animal>> species = new HashSet<>();
        for (Animal animal : animals) {
            species.add(animal.getClass());
        }
        return species;
    }

    public List<Animal> getMales(final Class<? extends Animal> species) {
        return byGender(species,
                        Gender.MALE);
    }

    public List<Animal> getFemales(final Class<? extends Animal> species) {
        return byGender(species,
                        Gender.FEMALE);
    }

    private List<Animal> byGender(final Class<? extends Animal> species,
                                  final Gender gender) {
        return animals.stream()
                      .filter(animal -> animal.gender == gender)
                      .filter(animal -> animal.getClass().equals(species))
                      .collect(Collectors.toList());
    }
}