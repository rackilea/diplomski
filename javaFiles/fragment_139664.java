prepStmt1 = connBlng.prepareStatement("update table set done='yes' where phone=?");  
while(...)  
{  
     prepStmt1.setString(1, phone);
     prepStmt1.addBatch();
}