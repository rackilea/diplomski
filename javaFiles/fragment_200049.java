public class Sort {

  public static void main(String[] args) {
    int[] arr = new int[] { 14, 9, 7, 7, 14 };
    Map<Integer, Temp> map = new HashMap<>();

    for (int i : arr) {
      Temp t = map.getOrDefault(i, new Temp(i));
      map.put(i, t.increment());
    }

    List<Integer> collect = map.values().stream()
      .sorted((o, t) -> o.count == t.count ? o.value - t.value : t.count - o.count)
      .map(t -> IntStream.range(0, t.count).map(i -> t.value)
      .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll))
      .flatMap(ll -> ll.stream())
      .collect(Collectors.toList());
    System.out.println(collect);

  }

  static class Temp {
    int value, count;
    public Temp(int i) {
      value = i;
    }
    public Temp increment() {
      count++;
      return this;
    }
  }
}