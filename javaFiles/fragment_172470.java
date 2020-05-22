public static Foo getFoo(String locale) {
  if ("en".equals(locale)) {
    return new Foo_en();
  } else if /*...
  ...*/

  throw new IllegalArgumentException("Locale " + locale + " is not supported");
}