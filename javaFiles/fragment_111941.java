List<Person> personList = new ArrayList<>();
Map<String, Person> collect = personList.stream()
        .collect(Collectors.toMap(Person::getType, a -> a, (p1, p2) ->
                new Person(p1.getX(), p1.getType(),
                        p1.getAge() + p2.getAge(),
                        p1.getCode() + p2.getCode()))); // named the other attribute 'code'