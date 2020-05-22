public class PriorityComparator implement Comparator<Priorizable>
{
  public int compare(final Priorizable p1, final Priorizable p2)
  {
      return Integer.compare(p1.getPriority(), p2.getPriority())
  }
}