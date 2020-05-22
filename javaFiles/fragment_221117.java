Connection con = DatabaseConnection.getConnection();
PreparedStatement ps = 
    con.prepareStatement
    ("SELECT questid FROM completedQuests WHERE characterid = ? AND questid = ?");
ps.setInt (1, characterId);
ps.setInt (2, questId);
ResultSet rs = ps.executeQuery();

if (rs.next()) {
    // Quest already completed
} else {
    // Quest not completed yet
}

// Close resources etc.