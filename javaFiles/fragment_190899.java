Map<String, Integer> teamsPoints = new HashMap<String, Integer>();
for (Player player : players)
{
    Integer teamPoints = teamsPoints.get(player.getTeamName());
    if (teamPoints == null)
        teamsPoints.put(player.getTeamName(), player.getPoints());
    else
        teamsPoints.put(player.getTeamName(), teamPoints + player.getPoints());
}