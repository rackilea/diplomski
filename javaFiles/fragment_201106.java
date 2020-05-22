String sql = "INSERT INTO VOTES (CANDIDATE_NAME, VOTER_SSN, TIMESTAMP) VALUES (?, ?, ?)";

try (PreparedStatement stm = connection.prepareStatement(sql)) {

    stm.setString(1, Candidate_Name );
    stm.setString(2, ssn );
    stm.setDate(3, TimeStamp);

    stm.executeUpdate();
}