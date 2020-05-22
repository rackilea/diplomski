List<Person> people = new ArrayList<>();

for (int i = 0; i < 100; i++) {
    people.add(new Person()); // 100 random genes
}

String mostCommonGene = people.stream()
                .map(Person::getGenes)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();

    System.out.println("Most common gene: " + mostCommonGene);