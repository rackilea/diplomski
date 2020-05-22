Map<String, Set<Person>> personByFirstName = 
                            persons.stream()
                                   .collect(Collectors.groupingBy(
                                                   Person::getFirstName, 
                                                   Collectors.toCollection(HashSet::new))
                                           );

persons.stream()
       .collect(Collectors.groupingBy(Person::getLastName, Collectors.toSet()))
       .forEach((str, set) -> personByFirstName.merge(str, set, (s1, s2) -> { 
            s1.addAll(s2); 
            return s1;
        }));

// personByFirstName contains now all personByName