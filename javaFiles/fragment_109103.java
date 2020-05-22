PreparedStatement ps=conn.prepareStatement(
    "CALL SYSCS_UTIL.SYSCS_EXPORT_TABLE (?,?,?,?,?,?)");
    ps.setString(1,null);
    ps.setString(2,"STAFF");
    ps.setString(3,"staff.dat");
    ps.setString(4,"%");
    ps.setString(5,null);
    ps.setString(6,null);
    ps.execute();