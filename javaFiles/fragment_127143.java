private static final Map<String, String> MAP;

static {
  Map<String, String> temp = new HashMap<String, String>();
  temp.put("a", "b");
  temp.put("b", "c");
  MAP = Collections.unmodifiableMap(temp);
}