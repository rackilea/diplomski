// assuming mat_pay is the name of a variable containing the table name
String query = String.format("INSERT INTO %s VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", mat_pay);

stmt = connec.prepareStatement(query);
stmt.setInt(1,septembre.var_m_p_g1); //septembre.var_m_p_g1 has a value 'integer'
stmt.setInt(2,id_g2); //septembre.var_m_p_g1 has a value 'integer'
stmt.setInt(3,0);
stmt.setInt(4,0);
stmt.setInt(5,0);
stmt.setInt(6,0);
stmt.setInt(7,0);
stmt.setInt(8,0);
stmt.setInt(9,0);
stmt.setInt(10,0);
stmt.setInt(11,0);
stmt.setInt(12,0);
stmt.executeUpdate();