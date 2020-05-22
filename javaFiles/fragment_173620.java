// Create an instance of the service you wish to use
// you can keep this around
Tmdb tmdb = new Tmdb();
tmdb.setApiKey("yourapikey");
MovieService movieService = tmdb.movieService();
//
// Call any of the available endpoints
Call<Movie> call = movieService.summary(550);
Movie movie = call.execute().body();
Call<Trailers> callTrailers = movieService.trailers(550);
Trailers trailers = callTrailers.execute().body();