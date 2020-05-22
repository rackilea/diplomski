List<Integer> intermediate = list.stream()
    //many other filters, flatmaps, etc...
    .filter(i -> condition(i))
    .collect(Collectors.toList());
boolean flag = !intermediate.isEmpty();
List<Integer> newList = intermediate.stream()
    //many other filters, flatmaps, etc...
    .collect(Collectors.toList());