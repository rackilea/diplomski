public class WithSequence {

    private static final String URL = "jdbc:h2:mem:seqdb";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL)) {
            initDb(connection);
            int id = getNextId(connection);
            insertClobWithId(id, connection);
            outputTableContent(connection);
        }
    }

    // creates table and sequence
    private static void initDb(Connection connection) throws SQLException {
        try (Statement ddlStmt = connection.createStatement()) {
            ddlStmt.execute("create table clobwithid ("
                    + " id integer primary key,"
                    + " clobvalue clob"
                    + ")");
            ddlStmt.execute("create sequence seq_clobwithid");
        }
    }

    // obtain next id from sequence
    private static int getNextId(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select next value for seq_clobwithid")) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new AssertionError(" next value for should produce value");
            }
        }
    }

    // generate and insert clob
    private static void insertClobWithId(int id, Connection connection) throws SQLException {
        String clobValue = "Something with id=" + id + " and other stuff";
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into clobwithid(id, clobvalue) values(?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, clobValue);

            pstmt.executeUpdate();
        }
    }

    private static void outputTableContent(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select id, clobvalue from clobwithid")) {
            while (rs.next()) {
                System.out.printf("%d : %s%n", rs.getInt(1), rs.getString(2));
            }
        }
    }
}