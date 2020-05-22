private void installOS_COMMAND() {
    Connection targetDBconn = null;
    Statement stmt = null;

    try {
        String SQL = "create or replace java source named \"FILE_TYPE_JAVA\" as\n"
                + "public class FileType {\n"
                + "    public static String getFileTypeOwner(Connection con) throws Exception {\n"
                + "    String sFileTypeOwner = null;\n"
                + "    CallableStatement stmt = con.prepareCall(\"begin dbms_utility.name_resolve(?,?,?,?,?,?,?,?); end;\");\n"
                + "    stmt.setString(1, \"FILE_TYPE\");\n"
                + "    stmt.setInt(2, 7);\n"
                + "    stmt.registerOutParameter(3, java.sql.Types.VARCHAR);\n"
                + "    stmt.registerOutParameter(4, java.sql.Types.VARCHAR);\n"
                + "    stmt.registerOutParameter(5, java.sql.Types.VARCHAR);\n"
                + "    stmt.registerOutParameter(6, java.sql.Types.VARCHAR);\n"
                + "    stmt.registerOutParameter(7, oracle.jdbc.OracleTypes.NUMBER);\n"
                + "    stmt.registerOutParameter(8, oracle.jdbc.OracleTypes.NUMBER);\n"
                + "    stmt.execute();\n"
                + "    sFileTypeOwner = stmt.getString(3);\n"
                + "    stmt.close();\n"
                + "    return sFileTypeOwner;\n"
                + "  }\n"
                + "}";
        targetDBconn = globalTargetConn.connect();
        stmt = targetDBconn.createStatement();
        stmt.setEscapeProcessing(false);
        stmt.executeUpdate(SQL);
    } catch (SQLException ex) { logWriter.writeLogs(logTextArea, LogWriter.ERROR, ex.getMessage());
    } finally {
        if (targetDBconn != null ) try {targetDBconn.close();} catch(SQLException ex) {}
    }
}