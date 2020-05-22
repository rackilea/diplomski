Stream.of(str)
      .map(splittingBy("\\s*+(?:[.!?]\\s*+)+"))
      .flatMap(Arrays::stream)
      .map(splittingBy("\\s+"))
      .mapToInt(arr -> arr.length)
      .max()
      .orElse(0);

...

static Function<String, String[]> splittingBy(String regex) {
    return str -> str.split(regex);
}