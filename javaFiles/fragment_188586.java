public static void main(String[] args) {

    System.out.println("************ArrayList after sorting************");

    Collections.sort(animalGroup,new AgeComparator()); // Sort highest to lowest

    for (Animal animal2 : animalGroup) {
        System.out.println(animal2.getName() + "," + animal2.getAge());
    }
}