PreparedStatement ps = con.prepareStatement("select customer_name, contact_no from customer_details where customer_id=?");                          
ps.setString(1,cust_id.getText()); 

rs = ps.executeQuery();

if (rs.next()) 
{                       
     cust_nm.setText(rs.getString("customer_name"));
     cont.setText(rs.getString("contact_no"));                       
 }