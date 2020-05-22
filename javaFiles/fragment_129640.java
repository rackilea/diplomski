do {
/*>*/action.accept((String)a[i])
    if (predicate.test(u)) { downstream.accept(u); }  // predicate is our fishPredicate
        downstream.accept(mapper.apply(u)); // mapper is our fishFunction
            accumulator.accept(u)
                // calls add(u) on resulting ArrayList
} while (++i < hi) // for each fish :)