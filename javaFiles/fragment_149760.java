class AnimalFinderClass<T extends Animal> implements Repository<T> {

    Repository<T> repository;

    private Class<T> animalType;


    public AbstractFinderClass(Class<T> animalType) {
        this.animalType = animalType;
    }

    public Option<T> findMyAnimal(String id) {
        return repository.findById(id, this.animalType);
    }
}