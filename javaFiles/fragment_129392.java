HomeTeamResults hometeamResults=null;  // Object is null
        while (rs.next()) 
        {               
            hometeam = rs.getString("HomeTeam");                      
            awayteam = rs.getString("AwayTeam");                   
            result = rs.getString("Result");                             
            custs = (hometeam + "," + awayteam + "," + result); // No idea abt usage
            hometeamResults = new HomeTeamResults(hometeam,awayteam,result); // Initial It
            allResults.add(hometeamResults);   // Now List will contain proper object
        }