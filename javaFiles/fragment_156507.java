List<TeamStanding> list = createStandingsTable(matches);
Map<Integer, TeamStanding> map = new HashMap<>();

for (TeamStanding team: list) {
    int id = team.getIdTeam();
    if (map.containsKey(id)) {
        TeamStanding other = map.get(id);
        other.setTeamPoints(team.getTeamPoints());
        other.setTeamPlayed(team.getTeamPlayed());
        // and so on...
    } else {
        map.put(id, team);
    }
}

List<TeamStanding> merged = new ArrayList<>(map.values());