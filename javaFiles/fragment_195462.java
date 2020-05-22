interface ITournament {
  public Boolean allScoresValid();
  public Boolean highCapacityVenue(int ticketsSold);
  public Boolean winnerAlwaysAdvanced();
  public Boolean tWinnerContestant1();
  public MatchData getMatchData();
}