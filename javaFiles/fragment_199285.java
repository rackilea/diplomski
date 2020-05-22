public static <T> List<Set<List<T>>> roundRobin(List<T> teams) {

    int numTeams = teams.size();

    // For a proper league, we only allow even number of teams.
    if ( numTeams % 2 != 0 ) {
        throw new IllegalArgumentException("Number of teams not even " + numTeams);
    }

    List<Set<List<T>>> result = new ArrayList<>(numTeams - 1);


    // Implement the round robin by rotating the right side of the list
    // every time, then pairing opposite teams. Note that the first
    // item is not part of the rotation.
    for ( int i = 0; i < numTeams - 1; i++ ) {
        Collections.rotate(teams.subList(1,numTeams), 1);
        Set<List<T>> bucket = new HashSet<>();
        for ( int j = 0; j < numTeams / 2; j++ ) {
            bucket.add(Arrays.asList(teams.get(j), teams.get(numTeams - j - 1)));
        }
        result.add(bucket);
    }
    return result;
}