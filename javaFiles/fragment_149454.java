String hostname=this.hostNameText.getText();
try
{
String q="SELECT * FROM hostdetails WHERE \"HOSTNAME\" = ?"; //notice change here

//and use params like this
PreparedStatement pStmnt = connection.prepareStatement(q);
pStmnt.setString(1, hostname);

rs = pStmnt.executeQuery(q);
}catch(Exception e)
{
//error handling here
}