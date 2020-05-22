// Regular Java
public Integer albuquerqueToLA(Map<String, Map<String, Integer>> map) {
  Map m = map.get("Albuquerque");
  if (m != null)
     return m.get("Los Angeles"); // May return null.
}

// Functional Java with product and option types.
public Option<Integer> albuquerqueToLA(TreeMap<P2<String, String>, Integer>() map) {
  return m.get(p("Albuquerque", "Los Angeles"));
}