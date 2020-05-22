B findElementByPredicate(Predicate<B> predicate) {
    for (B b : list) {
        if (predicate.apply(b))
            return b;
    }
    return null;
}