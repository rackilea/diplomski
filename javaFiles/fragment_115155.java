public void getCount() {

    Statement stmt = null;
    CallableStatement cstmt = null;

    try {

        stmt = con.createStatement();


        //p_get_count should be replaced by your procedure name
        String s1 = "call p_get_count(?); end;";
        cstmt = (CallableStatement) con.prepareCall(s1);
        cstmt.registerOutParameter(1, Types.VARCHAR);
        cstmt.execute();
        String s2 = cstmt.getString(1);
        System.out.println(s2);
        cstmt.close();
        stmt.close();

    } catch (SQLException e) {

        e.printStackTrace();

    }

}