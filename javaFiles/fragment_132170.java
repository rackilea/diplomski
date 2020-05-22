public static <T extends Model> List<T> getList(
    Class<T> c, int numberOfItems, StringReader reader)
{
  final List<T> l = new ArrayList<T>();
  try { for (int i = 0; i < numberOfItems; i++) l.add(c.newInstance());
  } catch (Exception e) { throw new RuntimeException(e); }
  return l;
}