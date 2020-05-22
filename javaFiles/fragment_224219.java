import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AnimalAdapter extends XmlAdapter<AnimalExtension, Animal> {

    @Override
    public Animal unmarshal(AnimalExtension animalExtension) throws Exception {
        if(0 != animalExtension.getAnimalId()) {
            return animalExtension;
        }
        Animal animal = new Animal();
        animal.setName(animalExtension.getName());
        return animal;
    }

    @Override
    public AnimalExtension marshal(Animal animal) throws Exception {
        if(animal.getClass() == AnimalExtension.class) {
            return (AnimalExtension) animal;
        }
        AnimalExtension animalExtension = new AnimalExtension();
        animalExtension.setName(animal.getName());
        return animalExtension;
    }

}