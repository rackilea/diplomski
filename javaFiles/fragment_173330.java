static Function<Tuple2<String, String>, String> mapFunc=new Function<Tuple2<String, String>, String>() {
    @Override
    public String call(Tuple2<String, String> tuple2) {
        return tuple2._2();
    }
}