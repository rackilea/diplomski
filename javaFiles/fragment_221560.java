Spliterator<String> sp = Stream.concat(
    Stream.of("foo").filter(s -> !s.isEmpty()),
    Stream.of("bar", "baz"))
    .spliterator();
do {
    System.out.println(
          "SIZED: "+sp.hasCharacteristics(Spliterator.SIZED)
        + ", SUBSIZED: "+sp.hasCharacteristics(Spliterator.SUBSIZED)
        + ", exact size if known: "+sp.getExactSizeIfKnown());
} while(sp.trySplit() != null);