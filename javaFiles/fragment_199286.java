List<String> teams = Arrays.asList(
                             "Manchester Utd.",
                             "Chelsea",
                             "Tottenham",
                             "Liverpool",
                             "Arsenal",
                             "West Ham Utd." );

    for ( Set<List<String>> bucket : roundRobin(teams)) {
        for ( List<String> pair : bucket) {
            System.out.println(pair);
        }
        System.out.println();
    }