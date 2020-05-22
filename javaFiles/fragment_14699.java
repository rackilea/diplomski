final String[] source = { "A", "B", "C" };
  final String[] destination = new String[source.length + 1];
  System.arraycopy(source, 0, destination, 0, source.length);
  destination[source.length] = "D";

  for(final String s : destination) {
     System.out.println(s);
  }