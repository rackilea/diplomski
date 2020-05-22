String query1 = "select substr(to_char(max_data),1,4) as year, " + 
  "substr(to_char(max_data),5,6) as month, max_data " +
  "from dss_fin_user.acq_dashboard_src_load_success " + 
  "where source = 'CHQ PeopleSoft FS'";

String query2 = ".....";

String sql = "insert into domo_queries (clob_column) values (?)";
PreparedStatement pstmt = con.prepareStatement(sql);
StringReader reader = new StringReader(query1);
pstmt.setCharacterStream(1, reader, query1.length());
pstmt.addBatch();

reader = new StringReader(query2);
pstmt.setCharacterStream(1, reader, query2.length());
pstmt.addBatch();

pstmt.executeBatch();   
con.commit();