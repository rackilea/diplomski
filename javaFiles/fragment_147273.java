Predicate<Integer> crazyFunction = x -> false;
for (Integer thisInteger : listOfIntegers) {
    crazyFunction = crazyFunction.or(Predicate.isEqual(thisInteger));
}

// Is a given integer one of our integers?
boolean isGoodInteger = crazyFunction.apply(42);