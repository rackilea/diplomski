@Test
public void printInOrder() {
  List<MyObject> list = new ArrayList<>();
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 10, 20).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Bill", Date.from(LocalDate.of(1990, 1, 2).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 2, 2).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("John", Date.from(LocalDate.of(1990, 9, 8).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Bill", Date.from(LocalDate.of(1990, 4, 4).atStartOfDay(ZoneId.systemDefault()).toInstant())));
  list.add(new MyObject("Frank", Date.from(LocalDate.of(1990, 5, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())));

  List<String> declaredNameOrder = new ArrayList<>(list.stream()
                                      .map(MyObject::getName)
                                      .collect(Collectors.toCollection(LinkedHashSet::new)));

  list.stream()
      .sorted(Comparator.<MyObject>comparingInt(o -> declaredNameOrder.indexOf(o.getName()))
                  .thenComparing(Comparator.comparing(MyObject::getDate)))
      .map(obj -> obj.getName() + " " + obj.getDate())
      .forEach(System.out::println);
}