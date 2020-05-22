int elimiateUserId = 11;
String css1 = "11,22,33,44,55";

String css1Result = Stream.of(css1.split(","))
    .filter(value -> !String.valueOf(elimiateUserId).equals(value))
    .collect(Collectors.joining(","));

// css1Result = 22,33,44,55