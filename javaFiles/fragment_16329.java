static void m() {
  Map<String, Function<Person, Comparable<?>>> map = new HashMap<>();
  map.put("name", Person::getName);
  map.put("age", Person::getAge);
  Comparator<Person> c = method(map);
}


@SuppressWarnings(value = {"unchecked", "rawtypes"})
static <T> Comparator<T> method(String name, Map<String, Function<T, Comparable<?>>> comparatorFunctionMap) {
  Function f = (Function) comparatorFunctionMap.get("age");
  Comparator<T> c = Comparator.comparing(f);
  return c;
}