public class Benchmark1
{
  static final List<Integer>[] lists = new List[10000]; static {
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<Integer>(1);
      lists[i].add(1);
    }
  }
  static final Collection<Integer>[] colls = new Collection[lists.length]; static {
    for (int i = 0; i < colls.length; i++) colls[i] = lists[i];
  }


  @GenerateMicroBenchmark
  public long testNoDowncast() {
    long sum = (long)Math.random()*10;
    for (int i = 0; i < lists.length; i++) sum += lists[i].get(0);
    return sum;
  }
  @GenerateMicroBenchmark
  public long testDowncast() {
    long sum = (long)Math.random()*10;
    for (int i = 0; i < colls.length; i++) sum += ((List<Integer>)colls[i]).get(0);
    return sum;
  }
}