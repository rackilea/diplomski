import static java.util.Comparators.naturalOrder;

Arrays.asList(-13, 12, 1337, 9)
  .stream()
  .max(naturalOrder())
  .ifPresent(System.out::println); // 1337