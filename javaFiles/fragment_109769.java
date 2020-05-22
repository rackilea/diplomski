Predicate<Integer> isEven = new Predicate<Integer>() {
        @Override public boolean apply(Integer number) {
            return (number % 2) == 0;
        }               
    };
    Iterable<Integer> evenNumbers = Iterables.filter(numbers, isEven);

    for (int number : evenNumbers) {
        process(number);
    }