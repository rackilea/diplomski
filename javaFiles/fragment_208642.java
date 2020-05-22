private Boolean parse() {

    try {
        JSONObject jsonObj = new JSONObject(jsonData);

        JSONArray ja = jsonObj.getJSONArray("standing");

        mLeagueTable.clear();  //Clears the ArrayList.

        for (int i = 0; i < ja.length(); i++)  //iterating in JSONArray
        {
            JSONObject jo = ja.getJSONObject(i);

            int position = jo.getInt(Integer.parseInt("position"));
            int points = jo.getInt(Integer.parseInt("points"));
            int playedGames = jo.getInt(Integer.parseInt("playedGames"));
            int goals = jo.getInt(Integer.parseInt("goals"));
            int goalsAgainst = jo.getInt(Integer.parseInt("goalsAgainst"));
            int goalDifference = jo.getInt(Integer.parseInt("goalDifference"));

            Standing table = new Standing();      //Create a new "User" object.

            table.setPosition(position);
            table.setPoints(points);
            table.setPlayedGames(playedGames);
            table.setGoals(goals);
            table.setGoalsAgainst(goalsAgainst);
            table.setGoalDifference(goalDifference);


            mLeagueTable.add(table);    //Add new Standing object to ArrayList mLeagueTable.
        }
        return true;

    } catch (JSONException e) {
        e.printStackTrace();
        return false;
    }
}