public class WithTrigger {

    private static final String URL = "jdbc:h2:mem:seqdb";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL)) {
            initDb(connection);
            insertClob(connection);
            outputTableContent(connection);
        }
    }

    // create database and trigger
    private static void initDb(Connection connection) throws SQLException {
        try (Statement ddlStmt = connection.createStatement()) {
            ddlStmt.execute("create table clobwithid ("
                    + " id integer auto_increment primary key,"
                    + " clobvalue clob"
                    + ")");
            ddlStmt.execute("create trigger bi_clobwithid before insert on clobwithid for each row call \"example.ClobUpdateTrigger\"");
        }
    }

    // insert clob with a placeholder to be modified by the trigger
    private static void insertClob(Connection connection) throws SQLException {
        String clobValue = "Something with id=##ID## and other stuff";
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into clobwithid(clobvalue) values(?)")) {
            pstmt.setString(1, clobValue);

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