public interface GitMovieApi {
    @GET("/3/movie/{movie}")  
    public void getMovie(@Path("movie") String typeMovie,
                @Query("api_key") String keyApi,
                Callback<MovieList> response);    
}