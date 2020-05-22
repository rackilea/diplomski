public class Benchmark1
{
  static Integer[] ints = new Integer[0];
  static {
    final List<Integer> list = new ArrayList(asList(1,2,3,4,5,6,7,8,9,10));
    for (int i = 0; i < 5; i++) list.addAll(list);
    ints = list.toArray(ints);
  }
  static List<Integer> intList = Arrays.asList(ints);
  static Vector<Integer> vec = new Vector<Integer>(intList);
  static List<Integer> list = new ArrayList<Integer>(intList);

  @GenerateMicroBenchmark
  public Vector<Integer> testVectorAdd() {
    final Vector<Integer> v = new Vector<Integer>();
    for (Integer i : ints) v.add(i);
    return v;
  }
  @GenerateMicroBenchmark
  public long testVectorTraverse() {
    long sum = (long)Math.random()*10;
    for (int i = 0; i < vec.size(); i++) sum += vec.get(i);
    return sum;
  }
  @GenerateMicroBenchmark
  public List<Integer> testArrayListAdd() {
    final List<Integer> l = new ArrayList<Integer>();
    for (Integer i : ints) l.add(i);
    return l;
  }
  @GenerateMicroBenchmark
  public long testArrayListTraverse() {
    long sum = (long)Math.random()*10;
    for (int i = 0; i < list.size(); i++) sum += list.get(i);
    return sum;
  }
}