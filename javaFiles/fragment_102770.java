Person orderedPersonAge  = personList
        .stream()
        .sorted(Comparator.comparing(Person::getAge).reversed())
        .map(s-> new Person(s.getAge(),"Super"+s.getName(),s.getSureName()))
        .collect(Collectors.toList())
        .get(0);
System.out.println(orderedPersonAge);