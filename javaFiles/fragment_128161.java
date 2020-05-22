List<String> l=Arrays.asList("hello", "world");
nonEmptyStream(l.stream(), ()->new RuntimeException("No strings available"))
  .forEach(System.out::println);
nonEmptyStream(l.stream().filter(s->s.startsWith("x")),
               ()->new RuntimeException("No strings available"))
  .forEach(System.out::println);