for (int i=0; i<movies.length(); i++) {
    try {
        JSONObject movie = movies.getJSONObject(i);
        JSONObject ratingsobj = movie.getJSONObject("ratings");
        String audrating = ratingsobj.get("audience_score").toString();
        audscore.add(audrating);
    } catch (Exception e) {
        audscore.add("Unavailable");
    }
}