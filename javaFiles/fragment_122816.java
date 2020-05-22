Function<Collection<Integer>, Number> additionFunction = new Function<Collection<Integer>, Number>() {
    @Override
    public Number apply(Collection<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number; 
        }
        return sum;
    }
};

Maps.transformValues(testMultimap.asMap(), additionFunction);