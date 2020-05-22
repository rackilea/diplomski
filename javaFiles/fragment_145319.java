@Test
public void printInOrder() {
  List<MyObject> list = new ArrayList<>(); // List containing your objects
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 10, 20).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Bill", Date.from(LocalDate.of(1990, 1, 2).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 2, 2).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("John", Date.from(LocalDate.of(1990, 9, 8).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Bill", Date.from(LocalDate.of(1990, 4, 4).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 5, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())));

  list.stream()
      .sorted(Comparator.comparing(MyObject::getName)
                        .thenComparing(Comparator.comparing(MyObject::getDate)))
      .map(obj -> obj.getName() + " " + obj.getDate())
      .forEach(System.out::println);
}