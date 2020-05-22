public static void main(String[] args) throws Exception {
    List<A> list = Arrays.asList(new A(1, 2), new A(3, 4), new A(11, 22));
    List<Integer> intList = list.stream().flatMap(anA -> Stream.of(anA.a, anA.b)).collect(Collectors.toList());
    System.out.println(intList);
    List<A> aList = IntStream.range(0, intList.size() / 2).mapToObj(i -> new A(intList.get(2 * i), intList.get(2 * i + 1))).collect(Collectors.toList());
    System.out.println(aList);
}