private List<PersonDTO> persons;

public List<PersonDTO> findBy(Predicate<PersionDTO> test) {
    return persons.stream().filter(test).collect(Collectors.toList());
}


// findByName
List<PersonDTO> david = findBy(p -> p.getName().startsWith("David "));

// find by age
List<PersonDTO> youngAdult= findBy(p -> p.getAge() >= 18 && p.getAge() <= 30);