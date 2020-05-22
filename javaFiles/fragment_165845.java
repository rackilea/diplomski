List<String> list = supplier.get();        // list = new ArrayList<>()
for (Person person : people)               // collect() loop using Spliterator from stream()
    if (filter.test(person)) {             // if (person.isAdult())
        String value = map.apply(person);  // value = person.getName()
        accumulator.accept(list, value);   // list.add(value)
    }
List<String> names = finisher.apply(list); // names = list