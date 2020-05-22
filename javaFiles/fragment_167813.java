class TeamScore {
    private final String name;
    private final int numGoals;
    public TeamScore(String name, int numGoals) {
        this.name = name;
        this.numGoals = numGoals;
    }
    // getters...
}


public List<TeamScore> viewTeams() throws SQLException {
    List<TeamScore> teamData = new ArrayList<>();
    String viewTeams = "SELECT * FROM HUI.TEAM ORDER BY GOALSSCORED DESC";
    connectToDatabase(dbName);
    stmt = dbConnection.createStatement();
    rs = stmt.executeQuery(viewTeams);
    while (rs.next()) {
        teamData.add(new TeamScore(rs.getString("TEAMNAME"), rs.getInt("GOALSSCORED"));
    }
    return teamData;
}