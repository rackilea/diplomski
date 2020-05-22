for (int i = 0; i<results.length();i++){
    movieObjs[i] = new MovieObj();
    JSONObject individualMovie = results.getJSONObject(i);
    String moviePosterTag = individualMovie.getString(POSTER_PATH);
    movieObjs[i].setMoviePosterTag(moviePosterTag);
}