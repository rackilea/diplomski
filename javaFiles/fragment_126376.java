get(){
Vector<Vector<String>> doublevector = new Vector<Vector<String>>();

Connection conn = dbConnection();//Your Database connection code goes in dbConnection()
PreparedStatement pre1 = conn.prepareStatement("select * from Table");

ResultSet rs1 = pre1.executeQuery();
while(rs1.next())
{
Vector<String> singlevector = new Vector<String>();
singlevector.add(rs1.getString(1)); 
singlevector.add(rs1.getString(2)); 
....
doublevector.add(singlevector);

}

return doublevector;
}