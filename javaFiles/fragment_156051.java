CallableStatement statement = null;
Connection conn = null;

    try {
        conn = getYourConnection();
        Calendar dbCal = new GregorianCalendar(YOUR_DATABASE_TIMEZONE);

        String sql = "begin schema_name.package_name.stored_proc(var1=>?, " +
                "var2=>?); end;";

        statement = conn.prepareCall(sql);
        statement.setInt(1, something);
        statement.setTimestamp(2, yourDate.getTime(), dbCal);

        statement.execute();

        conn.commit();

    } finally {
        if (statement!=null) statement.close();
        if (conn!=null) conn.close();
    }