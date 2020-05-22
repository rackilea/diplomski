public void calculateMostFavouriteForAge(int age) {

    Map<Integer, String> age2Sport = new HashMap<>();

    persons.values().stream()
            .collect(groupingBy(Person::getAge))
            .get(age).stream()
            .flatMap(p -> p.getFavourites().stream())
            .collect(groupingBy(i -> i, HashMap::new, counting()))
            .entrySet().stream()
            .max(comparingLong(Map.Entry::getValue))
            .ifPresent(entry -> age2Sport.put(age, entry.getKey()));
}