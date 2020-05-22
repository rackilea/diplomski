import java.util.AbstractMap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityTest {
  @SuppressWarnings("serial")
  private static class Entry extends AbstractMap.SimpleEntry<String, Integer> {
    private final static AtomicInteger seq = new AtomicInteger(0);
    final int order;
    public Entry(final String _key, final Integer _value) {
      super(_key, _value);
      order = seq.incrementAndGet();
    }
  }

  private static class OrderedComparator implements Comparator<Entry> {
    @Override
    public int compare(final Entry _e1, final Entry _e2) {
      int r = _e1.getValue().compareTo(_e2.getValue());
      if (r == 0)
        return Integer.compare(_e1.order, _e2.order);
      return r;
    }
  }

  public static void main(String[] args) {
    final PriorityQueue<Entry> pq = new PriorityQueue<Entry>(10, new OrderedComparator());
    pq.add(new Entry("Jane", 22));
    pq.add(new Entry("John", 15));
    pq.add(new Entry("Bill", 45));
    pq.add(new Entry("Bob", 22));
    while(!pq.isEmpty()) {
      System.out.println(pq.remove());
    }
  }
}