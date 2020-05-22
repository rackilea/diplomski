String mysqlQuery = "SELECT COUNT(*) FROM `cust_info` WHERE `"+column+"` ='"+value+"'";
rs = st.executeQuery(mysqlQuery);
if (rs.next() && (rs.getInt(1) != 0))
  printFoundIt(); // or whatever you want to do
else
  printDidntFindIt(); // or whatever you want to do
st.close();