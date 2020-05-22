StringBuffer sbSP = new StringBuffer();
    String query = "select c.text "
                  +"from syscomments c, sysobjects o "
                    +"where o.id=c.id and o.name='"+spName+"' order by c.colid";

    PreparedStatement stmt = connection.prepareStatement(query);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        //loop over every row of the stored procedure
        sbSP.append(rs.getString("text") + "\n");
    }