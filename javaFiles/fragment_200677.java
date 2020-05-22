List<MyData> list = new ArrayList<>();
list.add(new MyData("Mike", "x6", 5.0));
list.add(new MyData("Mike", "b4 ", 3.0));
list.add(new MyData("Mike", "y2", 1.0));
list.add(new MyData("Tom", "y2", 4.5));
List<MyData> sortedList = list.stream()
                              .sorted(Comparator.comparing(MyData::getName).thenComparing(MyData::getNumber))
                              .collect(Collectors.toList());