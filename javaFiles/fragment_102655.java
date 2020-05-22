String[] winnerData = ("Team_1#Team_2#...#Team_N").split("#");
// Create a Stream from the array of String
// For each String convert it as a Team using new Team(String)
// Convert the result as a List
List<Team> winners = Arrays.stream(winnerData)
    .map(Team::new)
    .collect(Collectors.toList());