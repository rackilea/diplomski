Stream<String> result = cartesian(
  (a, b) -> a + b, 
  Arrays.asList("A", "B"), 
  Arrays.asList("K", "L"), 
  Arrays.asList("X", "Y")
);