CallableStatement cs = con.prepareCall("{call my_procedure(?,?)}");  
int i = 0;
cs.setString(++i, advisor);
cs.setString(++i, adviceXml);

boolean isRs = cs.execute();
int updateCount = cs.getUpdateCount();
// cs.getUpdateCount() will return -1 if the current result is a ResultSet object 
// or there are no more results
// cs.getMoreResults() will return true  if the next result is a ResultSet object; 
// false if it is an update count or there are no more results

while (!isRs && (cs.getUpdateCount() != -1)) {
    isRs = cs.getMoreResults(); 
}

if (isRs) {
    ResultSet rs = cs.getResultSet();
    try {
        if (rs.next()) {
             groupId = rs.getString("psrg_idi");
        }
    } finally {
        rs.close();
    }
}