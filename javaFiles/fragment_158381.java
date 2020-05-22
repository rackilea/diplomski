@Test
public void buildMatchUps() {
    List<String> teams = Arrays.asList("A", "B", "C");
    int s = teams.size() * teams.size() - teams.size();
    List<String> matchUps = new ArrayList<String>(s);
    for(String host : teams) {
        for(String guest : teams) {
            if(host != guest) { // ref comparison, because the objects
                                // come from the same list. Otherwise
                                // equals should be used!
                matchUps.add(host + " : " + guest);
            }
        }
    }
    Collections.shuffle(matchUps);
    for(String matchUp : matchUps) {
        System.out.println(matchUp);
    }
}