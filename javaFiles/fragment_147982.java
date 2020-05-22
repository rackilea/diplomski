// turn your list into a stream
workingSet.stream()

// sort it...
.sorted(

    // first sort specifier: 0th element of Array
    Comparator.<String[], String>comparing(composite -> composite[0])

        // combine sort specifiers
        .thenComparing(

                // second sort specifier: 2st element of Array
                Comparator.<String[], String>comparing(composite -> composite[1])

                // REVERSED!
                .reversed()
        )
    )

// convert each array to a String
.map(Arrays::toString)

// print each String
.forEach(System.out::println);