interface Animal { AnimalId getId(); }
class AnimalId { int id; AnimalId(int id){this.id = id;} public boolean equals(Object o){ return id==((AnimalId)o).id; } public int hashCode(){ return 1; } }
class Cat implements Animal { AnimalId id; Cat(AnimalId id){this.id=id;} public AnimalId getId(){ return id; } public String catSpecific(){ return "CS"; } }
class Dog implements Animal { AnimalId id; Dog(AnimalId id){this.id=id;} public AnimalId getId(){ return id; } public String dogSpecific(){ return "DS"; } }

class Zoo {
    private Map<Class<? extends Animal>, Map<AnimalId, Animal>> animals = new HashMap<>();

    public <T extends Animal> void assignAnimal(T animal){
        animals.computeIfAbsent(animal.getClass(), k -> new HashMap<>()).put(animal.getId(), animal);
    }

    public <T extends Animal> T getAnimal(Class<T> type, AnimalId animalId){
        return type.cast(animals.get(type).get(animalId));
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        AnimalId animalId = new AnimalId(1);
        Animal animal1 = new Cat(animalId);
        Animal animal2 = new Dog(animalId);

        zoo.assignAnimal(animal1);
        zoo.assignAnimal(animal2);

        Cat cat = zoo.getAnimal(Cat.class, animalId);
        Dog dog = zoo.getAnimal(Dog.class, animalId);

        System.out.println(cat.catSpecific());
        System.out.println(dog.dogSpecific());
    }
}