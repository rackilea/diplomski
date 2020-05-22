FootballMatchCSVReader reader = new FootballMatchCSVReader();
        FootballMatchStatisticsEngine statisticsEngine = new FootballMatchStatisticsEngine();
        try {
            List<FootballMatch> footbalMatches = reader.read("src/test/resources/input.txt");
            List<TeamStatistic> teamStatistics = statisticsEngine.computeTeamStatistics(footbalMatches);
            teamStatistics.forEach(t -> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }