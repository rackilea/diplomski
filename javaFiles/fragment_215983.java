JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
  @Override
  public Iterable<String> call(String s) {
    return Arrays.asList(SPACE.split(s));
  }
});