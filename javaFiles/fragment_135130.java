//counts will have elements of the form (1, numberOfBytesInALine)    
JavaPairDStream<Integer, Integer> counts = words.mapToPair(new PairFunction<String, Integer, Integer>() {
    @Override
    public Tuple2<Integer, Integer> call(final String line) {
        return new Tuple2<Integer, Integer>(1, line.getBytes().length));
    }
});

//countOfWindow will have single element of the form (totalNumberOfLines, totalNumberOfBytes)
JavaDStream<Tuple2<Integer, Integer>> countOfWindow = counts.reduceByWindow(new Function2<Tuple2<Integer, Integer>,Tuple2<Integer, Integer>, Tuple2<Integer, Integer>> () {
    @Override
    public Tuple2<Integer, Integer> call(final Tuple2<Integer, Integer> a , final Tuple2<Integer, Integer> b) {
        return new Tuple2<Integer, Integer>(a._1 + b._1,  a._2 + b._2));
    }
}
,windowDuration,slideDuration);
countOfWindow.print();