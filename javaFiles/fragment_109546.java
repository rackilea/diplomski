Map<Integer, Assignment> assignments = unindexedAssignments.stream()
    .collect(Collectors.toMap(
        a -> a.getAssignmentID(),  // keys
        a -> a,                    // values
        (a, b) -> throw new IllegalStateException("duplicate lesson number"),
                                   // what to do if two items have the same key
        TreeMap::new               // map class constructor
    ));