dbStatement = con.createStatement();
dbInsert = con.createStatement();
dbResult = dbStatement.executeQuery("SELECT Vendor_Code FROM temp ORDER BY status ASC ");

while (dbResult.next())
{
    VendorCode=dbResult.getString("Vendor_Code");
    System.out.println(VendorCode);

    dbInsert.executeUpdate("INSERT INTO temp1 VALUES ('"+VendorCode+"')");
}