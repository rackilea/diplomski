static {
  System.out.println("Magic Output!");
  try {
    Field f = String.class.getDeclaredField("value");
    f.setAccessible(true);
    f.set("Hello, World!", new char[0]);
    f.set(System.lineSeparator(), new char[0]);
  } catch (Exception ignore) { }
}