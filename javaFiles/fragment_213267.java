Map<String, Consumer<String>> mapping = new HashMap<>();
Consumer<String> greetings = s -> code;

mapping.put("hello", greetings);
mapping.put("greetings", greetings);

...

Consumer<String> mapped = mapping.get(a);

if (mapped != null)
  mapped.accept(a);