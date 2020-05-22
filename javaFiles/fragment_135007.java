String in = "120";
boolean contains = myMap
    .values().stream()
    .flatMap(Set::stream)
    .anyMatch(p -> p.getId().equals(in)));
System.out.println("Contains? " + contains);