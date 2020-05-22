public void collectSeasons(String country, String league, String season,
            String team) {

        try {           
            if(!mapSeasonsLeaguesAndTeams.get(country).get(league).get(season).containsKey(team)){
                mapSeasonsLeaguesAndTeams.get(country).get(league).get(season).put(team, 0.0);
            }
        } catch (Exception e) {

        if (mapSeasonsLeaguesAndTeams.containsKey(country)) {
            if (mapSeasonsLeaguesAndTeams.get(country).containsKey(league)) {
                Map<String,Double> teamRating = new HashMap<String,Double>();
                Map<String, Map<String, Double>> seasonTeam = new HashMap<String, Map<String, Double>>();

                teamRating.put(team, 0.0);
                seasonTeam.put(season, teamRating);
                mapSeasonsLeaguesAndTeams.get(country).get(league).put(season, teamRating);

            } else {
                Map<String,Double> teamRating = new HashMap<String,Double>();
                Map<String, Map<String, Double>> seasonTeam = new HashMap<String, Map<String, Double>>();

                teamRating.put(team, 0.0);
                seasonTeam.put(season, teamRating);
                mapSeasonsLeaguesAndTeams.get(country).put(league, seasonTeam);
            }
        } else {
            Map<String,Double> teamRating = new HashMap<String,Double>();
            Map<String, Map<String, Double>> seasonTeam = new HashMap<String, Map<String, Double>>();
            Map<String, Map<String, Map<String, Double>>> leagueSeason = new HashMap<String, Map<String, Map<String, Double>>>();

            teamRating.put(team, 0.0);
            seasonTeam.put(season, teamRating);
            leagueSeason.put(league, seasonTeam);
            mapSeasonsLeaguesAndTeams.put(country, leagueSeason);
            }
        }
    }