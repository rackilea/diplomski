String mysqlQuery = "SELECT * FROM `cust_info` WHERE `"+column+"` ='"+value+"'";
rs = st.executeQuery(mysqlQuery);
boolean found_it = false;
while (rs.next())
{
  if (!found_it)
  {
    printFoundIt(); // or whatever you want to do
    found_it = true;
  }
  String ci = rs.getString("customer id");
  model.addRow(new Object[] {ci});
}
st.close();

if (!found_it)
  printDidntFindIt(); // or whatever you want to do