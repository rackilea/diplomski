public static void insertIntoTable(BigInteger id, SessionData sd, byte[] rtsd, IvissWorker ivissWorker) {
    PreparedStatement pstmt = null;
    Connection con = null;
    try {
        con = getConnection();
        pstmt = con
                .prepareStatement("REPLACE INTO iviss_session_table (id, ivissblob, rtblob, lastaccess) VALUES(?,?,?,?)");
        pstmt.setLong(1, Long.parseLong(id.toString()));
        pstmt.setBytes(2, IvissUtil.getBytes(sd));
        pstmt.setObject(3, rtsd);
        pstmt.setDate(4, new Date(System.currentTimeMillis()));
        pstmt.executeUpdate();
        // System.out.println("Stored/Replaced session with ID: " + id +
        // " in table.");
    } catch (SQLException e) {
        ivissWorker.getIvissWorkerOutputHandler().addError(Constants.ERROR_205, "", DbConfiguration.getDbUri());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}