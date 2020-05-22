Iterable<Person> filtered = Iterables
            .filter(
                persons, 
                Predicates.not(
                    Predicates.compose(
                        Predicates.in(ImmutableSet.copyOf(Iterables.transform(subsetOfPersons, personToNamefunction))),
                        personToNamefunction
                    )
                )
            );