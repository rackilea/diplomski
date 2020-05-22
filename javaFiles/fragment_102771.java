Person orderedPersonAge  = personList
        .stream()
        .sorted(Comparator.comparing(Person::getAge).reversed())
        .map(s-> new Person(s.getAge(),"Super"+s.getName(),s.getSureName()))
        .findFirst()
        .get();
System.out.println(orderedPersonAge);