import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortDemo
{
  public class Sort implements Comparator<Map.Entry>
  {
    public int compare(Entry o1, Entry o2)
    {
      Double valueOne = (Double) o1.getValue();
      Double valueTwo = (Double) o2.getValue();
      return (int) Math.signum(valueOne.compareTo(valueTwo));
    }
  }

  public static void main(String[] args)
  {
    new SortDemo().foo();
  }

  void foo()
  {
    TreeMap tm = new TreeMap();
    tm.put(1, new Double(3434.34));
    tm.put(0, new Double(123.22));
    tm.put(4, new Double(1378.00));
    tm.put(2, new Double(99.22));
    tm.put(3, new Double(-19.08));

    List<Map.Entry> valueList = new ArrayList(tm.entrySet());
    Collections.sort(valueList, new Sort());

    Iterator<Map.Entry> iterator = valueList.iterator();
    while (iterator.hasNext())
    {
      Map.Entry entry = iterator.next();
      System.out.println("Value: " + entry.getValue());
    }
  }
}