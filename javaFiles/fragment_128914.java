@Override
protected void onPostExecute(String result) {
   if(mMovieJsonStr != null){
    mPosterMoviePaths =  MovieDataParser.getMoviePosterPaths(mMovieJsonStr);
   }
   mMoviesAdapter = new MovieAdapter(Your_Activity_Name.this, mPosterMoviePaths);
   mMoviesGrid.setAdapter(mMoviesAdapter);
}