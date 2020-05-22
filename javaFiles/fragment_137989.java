private static int testTvp(DataSource ds, List<Integer> accountIds)  throws SQLException {
    final String sql = "EXEC dgTest.GetAccountsFromTvp @accountIds=?";

    try (Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        DelegatingPreparedStatement dstmt = (DelegatingPreparedStatement)stmt;
        SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement)dstmt.getInnermostDelegate();

        SQLServerDataTable accounts = new SQLServerDataTable();
        accounts.addColumnMetadata("token", java.sql.Types.INTEGER);
        for (Integer aid : accountIds)
            accounts.addRow(aid);

        pstmt.setStructured(1, "dgTest.IntegerTable", accounts);

        //// NOTE: The below works for JTDS driver, official MS driver said no result sets were returned
        //try (ResultSet rs = pstmt.executeQuery()) {
        //  return sumInts(rs);
        //}

        if (pstmt.execute()) {
            try (ResultSet rs = pstmt.getResultSet()) {
                return sumInts(rs);
            }
        }
        return -1;
    }
}