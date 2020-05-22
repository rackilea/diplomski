public static void main(String[] args) {
    Function<Integer, Double> t = new Function<Integer, Double>() {

        @Override
        public Double apply(Integer t) {
            return t.doubleValue();
        }
    };

    callFunction(t, 10);

    t = (i) -> i.doubleValue();
    callFunction(t, 10);

    t = (Integer i) -> {return i.doubleValue();};
    callFunction(t, 10);

    callFunction((i) -> i.doubleValue(), 10);

}

private static Double callFunction(Function<Integer, Double> f, Integer i){
    return f.apply(i);
}