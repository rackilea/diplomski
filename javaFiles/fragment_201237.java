List<String> oldList = new ArrayList<>();
List<String> newList = new ArrayList<>();

oldList
    //.stream()
    //.parallel() 
    .forEach(s1 ->
    newList
        .stream()
        .filter(s2 -> s1.equals(s2)) //could become a parameter Predicate
        .forEach(System.out::println) //could become a parameter Consumer
);