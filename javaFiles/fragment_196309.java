JavaDStream<String> lines = { ..... };
JavaPairDStream<String, Integer> pairs = lines.mapToPair(new PairFunction<String, String, Integer>() {
    @Override
    public Tuple2<String, Integer> call(String t) throws Exception {
        String[] words = t.split(",");
        return new Tuple2<String, Integer>(words[15],Integer.parseInt(words[7]));
    }
});