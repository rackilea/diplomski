public static void printAnimal(int id) throws NoSuchAnimalException {
    if (id == DEER) {
        System.out.println("Deer");
    } else if (id == BIRD) {
        System.out.println("Bird");
    } else if (id == COW) {
        System.out.println("COW");
    } else if (id == PIG) {
        System.out.println("Pig");
    } else {
        throw new NoSuchAnimalException("No such animal");
    }
}

public static void main(String[] args) {
    try {
        printAnimal(6);
    } catch (NoSuchAnimalException e) {
        System.out.println(e.getMessage());
    }
}