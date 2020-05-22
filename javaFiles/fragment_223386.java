ResultSet rs =sta.executeQuery("SELECT Quantity FROM stockDB WHERE Name='"+name+"' AND Size="+size+"");

while(rs.next())
{

String str = rs.getString("Quantity");
int quan = Integer.parseInt(str);
.....
}