//sample about the class
public class TeamMember {
    private String name;
    private int projectHours;
    //constructor...
    public TeamMember() {
    }
    //constructor sending parameters (because I'm lazy when having a class with few parameters)
    public TeamMember(String name, int projectHours) {
        this.name = name;
        this.projectHours = projectHours;
    }
    //getter and setters...
}

List<TeamMember> teamMembers = new ArrayList<TeamMember>();
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
    con = ... //initialize the connection
    String query = "SELECT tm.name, sum(pt.hours) AS hours FROM TEAM_MEMBERS tm " +
        "INNER JOIN PROJECT_TIME pt ON pt.teamMemberId = tm.id " +
        "WHERE DATE = ? GROUP BY tm.name";
    pstmt = con.prepareStatement(query);
    pstmt.setString(1, date); //assuming you have your date in String format
    //pstmt.setDate(1, date); //you could use this if your date variable is java.util.Date
    rs = pstmt.execute();
    while(rs.next()) {
        teamMembers.add(new TeamMember(rs.getString("name"), rs.getInt("hours"));
    }
} catch (Exception e) {
    //handle the Exception
} finally {
    //close the resources (this is a MUST DO)...
    try {
        if (rs != null) {
            rs.close();
        }
    } catch (SQLException sqle) {}
    try {
        if (pstmt != null) {
            pstmt.close();
        }
    } catch (SQLException sqle) {}
    try {
        if (con != null) {
            con.close();
        }
    } catch (SQLException sqle) {}
}