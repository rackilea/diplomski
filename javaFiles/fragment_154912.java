ResultSet rs = null;
PreparedStatement st = null;
try {...
String ID = req.getParameter("T1"); 
            String query = "select 1 from user_db where col_name = ?"; 
            st = conn.prepareStatement(query);
            st.setString(1, ID);  
            rs = st.executeQuery();
if (rs.next()) {
  out.println(ID); 
  out.println("<html><body><h> login Pass.....:(</h></body></html>"); 
}
..

} finally {
if (rs != null) try { rs.close();}catch (Exception e) {}
if (st != null) try { st.close();}catch (Exception e) {}
}