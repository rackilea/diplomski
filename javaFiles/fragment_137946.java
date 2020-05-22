Connection con = YOUR_CONNECTION;
PreparedStatment ps = con.prepareStatment(YOU SELECT);

ResultSet  result = ps.executeQuery();
while (result.next())
{
  pieModel.set(result.getSting("branch_code"), result.gtInt("accounts_opened "));
}