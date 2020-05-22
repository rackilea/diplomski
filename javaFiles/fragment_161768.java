ResultSet rs = s.executeQuery("SELECT VOTES FROM SURVEYRESULTS");
while(rs.next()){
        voteDataDog = rs.getInt("VOTES");
        voteDataCat = rs.getInt("VOTES");
        voteDataBird = rs.getInt("VOTES");
        voteDataSnake = rs.getInt("VOTES");
        voteDataNone = rs.getInt("VOTES");
    }