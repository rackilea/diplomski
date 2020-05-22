// Accumulate names into a List
 List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

 // Convert elements to strings and concatenate them, separated by commas
 String joined = things.stream()
                       .map(Object::toString)
                       .collect(Collectors.joining(", "));