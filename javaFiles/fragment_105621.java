private static final String fileName = "D:/data/db/alterseq.fdb";

public static void main(String[] args) throws Exception {
    FBManager manager = new FBManager();
    manager.setCreateOnStart(true);
    manager.setDropOnStop(true);
    manager.setUserName("sysdba");
    manager.setPassword("masterkey");
    manager.setFileName(fileName);
    manager.start();
    try (Connection con = DriverManager.getConnection(
            "jdbc:firebirdsql://localhost/" + fileName, "sysdba", "masterkey")) {
        try (Statement ddlStmt = con.createStatement()) {
            ddlStmt.execute("CREATE SEQUENCE seq_test");
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "ALTER SEQUENCE seq_test RESTART WITH 100")) {
            pstmt.execute();
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "SET GENERATOR seq_test TO 200")) {
            pstmt.execute();
        }
    } finally {
        manager.stop();
    }
}