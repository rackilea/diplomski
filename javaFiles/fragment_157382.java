List<MyDayObject> allHighest = 
    weeks.values() // produces a Collection<List<MyDayObject>>
         .stream() // produces a Stream<List<MyDayObject>>
         .map(list -> list.stream() // transforms each List<MyDayObject> to a MyDayObject 
                                    // to obtain a Stream<MyDayObject>
                          .max((o1, o2) -> o1.value().compareTo(o2.value())).get())
         .collect(Collectors.toList()); // collects the elements to a List