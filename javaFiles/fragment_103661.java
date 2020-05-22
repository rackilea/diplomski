public AnimalGroup<? extends Animal> getAnimalGroup (String animalName) {
    Class<? extends Animal> animalClass = Doge.class;

    if("Yetti".equals(animalName)) {
        animalClass = Yetti.class;
    }

    AnimalGroup<? extends Animal> animalGroup = new AnimalGroup<>(animalClass);
    animalGroup.doSomeProcessing();
    return animalGroup;
    }