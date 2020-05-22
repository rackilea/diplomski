Map<String, Class<?>> contents = ImmutableMap.of(
   "{\"foo\": \"123\"}", Foo.class,
   "{\"bar\": \"123\", \"bar2\": \"123\"}", Bar.class
);


for (Map.Entry<String, Class<?>> e : contents.entrySet) {
   Object obj = deserialise(e.getKey(), e.getValue());
}