public int getLeaguePosition(String username)
{
    try
    {
        String leagueName = getLeague(username);
        System.out.println("League Name: " + leagueName);

        // This is returning all the users in the same league sorted by descending points.

        String query = "SELECT * FROM Users WHERE CurrentLeague = ? ORDER BY TotalPoints DESC";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, leagueName);
        resultSet = preparedStatement.executeQuery();

        int leaguePosition = 0;
        while(resultSet.next())
        {
            // Since the result set is already sorted, the first player has the most points, so his
            // leaguePosition is one. The second has the next best number of points, so his position
            // is two, and so on. So we keep the leaguePosition var based on the number of the row.

            leaguePosition++;

            // And if the user name retrieved actually matches the one that we passed, then this is
            // his league position.

            String retrievedUsername = resultSet.getString("Username");
            if ( retrievedUsername.equals( username ) ) {
                break;
            }

        }
        resultSet.close();

        return leaguePosition;

    }
    catch(Exception e)
    {
        System.out.println("Couldn't get league position for: " + username);
        e.printStackTrace();
    }
    return 0;
}