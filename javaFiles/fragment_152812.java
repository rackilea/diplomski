// import static java.util.stream.Collectors.groupingBy;

List<Pojo> pojos = new ArrayList<>(Arrays.asList(
    new Pojo(1, BigDecimal.ONE, "IU", "6896450", "5500"),
    // ...,
    new Pojo(1, BigDecimal.valueOf(8), "DU", "7132952", "5500")));

// Create a map (`opMapByTag`) by `Tag`,
// within the results/pojos create another map (`pojosByOp`) by `Operation`
Map<String, Map<String, List<Pojo>>> opMapByTag =
    pojos.stream().collect(
        groupingBy(Pojo::getTag,
           groupingBy(Pojo::getOperation)));

Set<Pojo> toBeRemoved = new HashSet<>();

for (Entry<String, Map<String, List<Pojo>>> e : opMapByTag.entrySet())
{
  Map<String, List<Pojo>> pojosByOp = e.getValue();
  List<Pojo> l1, l2;
  if ((pojosByOp.size() == 2) &&
      ((l1 = pojosByOp.get("IU")).size() == 1) &&
      ((l2 = pojosByOp.get("DU")).size() == 1))
  {
    Collections.addAll(toBeRemoved, l1.get(0), l2.get(0));
  }
}

pojos.removeIf(toBeRemoved::contains);

pojos.forEach(System.out::println);