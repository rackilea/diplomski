public interface LeaguesApi
{
    @GET("/api/get-leagues")
    Observable<League> getLeagues(@Query("active_only") boolean activeOnly);
}

public interface LeagueApi
{
    @GET("/api/get-league-fixtures/{leagueId}")
    Observable<Match> getMatchesPlayed(@Path("leagueId") int leagueId, @Query("played") boolean played);
}