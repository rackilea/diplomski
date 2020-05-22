// via ProcessFunction
PCollection p1 = p.apply(Create.of(LINES))
  .apply(MapElements.into(TypeDescriptors.lists(TypeDescriptors.strings()))
                    .via((String word) -> (Arrays.asList(word, "Its weekend!"))))
  .apply(ParDo.of(new PrintResultsFn()));

// via in-line SimpleFunction
PCollection p2 = p.apply(Create.of(LINES))
  .apply(MapElements.via(new SimpleFunction<String, List<String>>() {
    public List<String> apply(String word) {
      return Arrays.asList(word, "Its weekend!");
    }}))
  .apply(ParDo.of(new PrintResultsFn()));

// via AddFieldFn class 
PCollection p3 = p.apply(Create.of(LINES))
  .apply(MapElements.via(new AddFieldFn()))
  .apply(ParDo.of(new PrintResultsFn()));