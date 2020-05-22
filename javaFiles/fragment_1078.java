public String getPoints(String team){
    String teamName;
    for ( FootballClub club : league )
    {
        teamName = club.getName();
        if ( teamName.trim().toLowerCase().equals( team ) )
        {
            return ( team + "  " + club.getPoints() ) + " Points";
        }
    }
    return "null or some string if .equals( team ) false for all clubs";
}