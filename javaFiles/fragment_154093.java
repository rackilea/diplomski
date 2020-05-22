public static void main(String[] args) throws Exception {
  final Object o = "";
  for (Method m : o.getClass().getMethods())
    if (m.getName().startsWith("get") && m.getParameterTypes().length == 0) {
      final Object r = m.invoke(o);
      // do your thing with r
    }
}