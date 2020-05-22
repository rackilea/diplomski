public class FetchMovieData extends AsyncTask <String, Void, Void> {

@Override
protected Void doInBackground(String... params) {

    // These two need to be declared outside the try/catch
    // so that they can be closed in the finally block.
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;

    try {
        // Construct the URL for the OpenWeatherMap query
        // Possible parameters are available at OWM's forecast API page, at
        // http://openweathermap.org/API#forecast
        URL url = new URL(getString(R.string.picasso_url_popular_movies));

        // Create the request to OpenWeatherMap, and open the connection
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        // Read the input stream into a String
        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer buffer = new StringBuffer();
        if (inputStream == null) {
            // Nothing to do.
            mMovieJsonStr = null;
        }
        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
            // But it does make debugging a *lot* easier if you print out the completed
            // buffer for debugging.
            buffer.append(line + "\n");
        }

        if (buffer.length() == 0) {
            // Stream was empty.  No point in parsing.
            mMovieJsonStr = null;
        }
        mMovieJsonStr = buffer.toString();
    } catch (IOException e) {
        Log.e("PlaceholderFragment", "Error ", e);
        // If the code didn't successfully get the weather data, there's no point in attempting
        // to parse it.
        mMovieJsonStr = null;
    } finally{
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (final IOException e) {
                Log.e("PlaceholderFragment", "Error closing stream", e);
            }
        }
    }

    return null;
  }
 ****Below is the onPostExecute method****

@Override
protected void onPostExecute(String result) {
   if(mMovieJsonStr != null){
    mPosterMoviePaths =  MovieDataParser.getMoviePosterPaths(mMovieJsonStr);
   }
   mMoviesAdapter = new MovieAdapter(Your_Activity_Name.this, mPosterMoviePaths);
   mMoviesGrid.setAdapter(mMoviesAdapter);
}

}