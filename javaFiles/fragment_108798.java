List<Ranking> rankingList = new ArrayList<>();

try {
    JSONArray array = json.optJSONArray("scores");

    for (int i = 0; i < array.length(); i++) {
        JSONObject rankingObject = array.getJSONObject(i);

        Ranking ranking = new Ranking();
        ranking.setPlace(rankingObject.getInt("place"));
        ranking.setNick(rankingObject.getString("nick"));
        ranking.setScore(rankingObject.getInt("score"));
        ranking.setDate(rankingObject.getString("date"));

        rankingList.add(ranking);
    }
} catch (JSONException j) {
    j.printStackTrace();
}

// do whatever you want with rankingList