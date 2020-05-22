String sql = "SELECT session_id FROM log_table ORDER BY session_id asc"; 

       int position = 0;    // Number of nth Position

        while (resultSet.next()) {

        if (resultSet.last()) 
        {
            position = resultSet.getRow();
            latestSessionID = resultSet.getInt(1);
            //
            latestSessionID = resultSet.getInt("SESSION_ID");
            System.out.println("Number of sessions = " + position + ", Session ID is : " + latestSessionID);
        }