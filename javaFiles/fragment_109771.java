Predicate<Integer> isPositive = new Predicate<Integer>() {
    @Override public boolean apply(Integer number) {
        return number > 0;
    }       
};

//...
if (Iterables.all(numbers, isPositive)) {
    System.out.println("Yep!");
}