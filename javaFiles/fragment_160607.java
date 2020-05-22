Map<String,Double> totalScore = new HashMap<>();
        for (int j =0; j< 40; j++){
    Double tmp = totalScore.get (team[j]);
    if (tmp != null)
    {
        totalScore.put(team[j], statsDub[j]+tmp);
    }
    else
            totalScore.put(team[j], statsDub[j]);
        }