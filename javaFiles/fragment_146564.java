Map<String, Long> result =
        Stream.of("b", "a", "c", "b")
              .collect(ImmutableSortedMap.toImmutableSortedMap(
                  Comparator.naturalOrder(),
                  Function.identity(),
                  x -> 1L,
                  Long::sum
              ));