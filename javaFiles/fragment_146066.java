List<Optional<String>> optionalNames = ImmutableList.of(
    Optional.of("Tom"), Optional.<String>absent(), Optional.of("Dick"),
    Optional.of("Harry"), Optional.<String>absent());

Iterable<String> presentNames = Optional.presentInstances(optionalNames); // lazy

// copy to List if needed
List<String> presentNamesList = ImmutableList.copyOf(presentNames);
System.out.println(presentNamesList); // ["Tom", "Dick", "Harry"]