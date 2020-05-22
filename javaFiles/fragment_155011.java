public abstract class Countable
{
    private static final Map<Class<?>, Integer> sTotalCounts = new HashMap<>();

    public Map<Class<?>, Integer> getCountsMap() {
        return sTotalCounts;
    }

    public int getTotalCount()
    {
        return sTotalCounts.get(this.getClass());
    }

    public Countable()
    {
      int count = 0;

      //Add if it does not exist.
      if(sTotalCounts.containsKey(this.getClass()))
      {
          count = sTotalCounts.get(this.getClass());
      }
      sTotalCounts.put(this.getClass(), ++count);
    }
}