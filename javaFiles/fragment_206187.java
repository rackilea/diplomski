interface Function<T> {
  T operate(T val);
}

public static <T> void replaceValues(Map<?, T> map, Function<T> f)
{
  for (Map.Entry<?, T> e : map.entrySet())
    e.setValue(f.operate(e.getValue()));
}

Util.replaceValues(myMap, new Function<String>() {
  public String operate(String val)
  {
    return (val == null) ? null : val.trim();
  }
});