String mysqlQuery = "SELECT * FROM `cust_info` WHERE `"+column+"` ='"+value+"'";
rs = st.executeQuery(mysqlQuery);
boolean found_it = false;
while (rs.next())
{
  found_it = true;
  String ci = rs.getString("customer id");
  model.addRow(new Object[] {ci});
}
st.close();

if (found_it)
  printFoundIt(); // or whatever you want to do
else
  printDidntFindIt(); // or whatever you want to do