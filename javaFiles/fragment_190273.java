Person personToFind = new Person("Doe", "Jane");

Person person = persons.stream()
    .filter(p -> p.equals(personToFind))
    .findFirst()
    .orElseGet(() -> 
        persons.stream()
            .filter(p -> p.getSurname().equals(personToFind.getSurname()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Could not find person ..."))
    );