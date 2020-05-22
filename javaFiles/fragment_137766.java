List<Person> unique = persons.stream()
                     .collect(Collectors.groupingBy(Person::getCustomerNumber)) //returns a Map<String,List<Person>> with customerNumber as key
                     .values()
                     .stream()   // stream and sort each list 
                     .map(e-> e.stream().sorted(
                        Comparator.comparing(Person::getBirthday)
                                  .thenComparing(Person::getBirthTime))
                       .findFirst().get())    // map to first Person obj
                     .collect(Collectors.toList());  

unique.forEach(System.out::println);