public static class BadBunnyHole extends AnimalHome {

    public BadBunnyHole(Animal animal) {
        super(animal);
    }

    public Bunny getBunny() {
        return (Bunny) getAnimal();
    }