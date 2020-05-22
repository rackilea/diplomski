Stream.of("Hello", "World", "!")
      .map(s -> new Object[] {s, s.length()})
      .filter(a -> ((int) a[1]) > 1)
      .forEach(a -> System.out.println(a[0] + ": " + a[1]));

Stream.of("Hello", "World", "!")
      .map(s -> new AbstractMap.SimpleEntry<>(s, s.length()))
      .filter(e -> e.getValue() > 1)
      .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));