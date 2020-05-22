sortedByAverageOne.entrySet().stream()
        .map(e -> String.format(
                "%s → %f → %f → %f",
                e.getKey(),
                average(e, MyObject::getDoubleOne),
                average(e, MyObject::getDoubleTwo),
                average(e, MyObject::getDoubleThree)
        ))
        .forEach(System.out::println);