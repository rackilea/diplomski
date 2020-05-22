List<Integer> source=IntStream.range(0, 20).boxed().collect(toList());
System.out.println(source);
int listCount=5;

Map<Integer, List<Integer>> collect = IntStream.range(0, source.size()).boxed()
  .collect(groupingBy(i->i%listCount, LinkedHashMap::new, mapping(source::get, toList())));
// in case it really has to be a List:
List<List<Integer>> result=new ArrayList<>(collect.values());

result.forEach(System.out::println);