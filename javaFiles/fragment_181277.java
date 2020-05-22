List<Fish> fishList = Arrays.asList(
    new Fish(200, 200), 
    new Fish(100, 500),
    new Fish(100, 300)
);

for (Fish fish : fishList) {
    System.out.println("Fish: " + fish);
}

// since Java 8:
fishList.forEach(fish -> System.out.println("Fish: " + fish));