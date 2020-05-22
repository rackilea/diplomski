OptionalInt result = IntStream.range(0, arr.length)
        .filter(i -> element == arr[i]) // .equals( ??
        .findFirst();
if (result.isPresent()) {
  System.out.printf("Element : %s has been found at the index : %d%n", element, result.getAsInt());
} else {
  // none found
  System.out.printf("Element %s not found%n", element);
}