ResultSet rs = null;
    try
    {
        rs = stmt.executeQuery ();
        rs.next ();

        Clob clob = rs.getClob (1);
        clob.truncate (0);
        clob.setString (1, data);
    }
    finally
    {
        rs = DBUtil.close (rs);
    }