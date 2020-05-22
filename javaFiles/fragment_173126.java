protected void onPostExecute(ArrayList<MovieItem> movieData) {
  if (movieData != null) {
     for (MovieItem movie : movieData) {
         mMoviesList.append((movie) + "\n\n\n");
     }
  }
}