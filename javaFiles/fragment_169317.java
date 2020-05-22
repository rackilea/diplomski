public class FootballMatchStatisticsEngine {

    public List<TeamStatistic> computeTeamStatistics(List<FootballMatch> footballMatches) {
        List<TeamStatistic> teamStatistics = getTeamStatistics(footballMatches);
        updatePosition(teamStatistics);
        return teamStatistics;
    }

    private void updatePosition(List<TeamStatistic> teamStatistics) {
        /*
        This function apply the relative table position to each TeamStatistics.
         */
               IntStream.range(0,teamStatistics.size()).forEach(i -> teamStatistics.get(i).setTablePosition(i+1));
    }

    private List<TeamStatistic> getTeamStatistics(List<FootballMatch> footballMatches) {
        /*
        The flat operation explode each match into two different TeamStatistics. One for home team and one for away team.
        After I compute the groupBy operation over team name and reduce the resulting list of Team statistics sumurizing her data.
         */
        return footballMatches
                .stream()
                .flatMap(fm -> footballMatchtoTeamStatistics(fm).stream())
                .collect(groupingBy(TeamStatistic::getTeamName, reducing(getTeamStatisticReduceOperation())))
                .values().stream().map(Optional::get)
                .sorted(comparingInt(TeamStatistic::getPoints).reversed())
                .collect(Collectors.toList());
    }

    private BinaryOperator<TeamStatistic> getTeamStatisticReduceOperation() {
        return (x, y) ->
                new TeamStatistic(
                        x.getTeamName(),
                        x.getNumberWin() + y.getNumberWin(),
                        x.getNumberDraw() + y.getNumberDraw(),
                        x.getNumberLoss() + y.getNumberLoss(),
                        x.getMatchesPlayed() + y.getMatchesPlayed(),
                        x.getPoints() + y.getPoints(),
                        x.getGoalsScored() + y.getGoalsScored(),
                        x.getGoalsConceded() + y.getGoalsConceded(), 0);
    }

    private List<TeamStatistic> footballMatchtoTeamStatistics(FootballMatch footballMatch) {
        return Arrays.asList(
                new TeamStatistic(
                        footballMatch.getHomeTeam(),
                        footballMatch.getFinalResult() == 'H' ? 1 : 0,
                        footballMatch.getFinalResult() == 'D' ? 1 : 0,
                        footballMatch.getFinalResult() == 'A' ? 1 : 0,
                        1,
                        footballMatch.getFinalResult() == 'H' ? 3 : footballMatch.getFinalResult() == 'D' ? 1 : 0,
                        footballMatch.getHomeTeamScore(),
                        footballMatch.getAwayTeamScore(),
                        0),
                new TeamStatistic(
                        footballMatch.getAwayTeam(),
                        footballMatch.getFinalResult() == 'A' ? 1 : 0,
                        footballMatch.getFinalResult() == 'D' ? 1 : 0,
                        footballMatch.getFinalResult() == 'H' ? 1 : 0,
                        1,
                        footballMatch.getFinalResult() == 'A' ? 3 : footballMatch.getFinalResult() == 'D' ? 1 : 0,
                        footballMatch.getAwayTeamScore(),
                        footballMatch.getHomeTeamScore(),
                        0)
        );
    }

}