int nameWidth = 15
int rollNumberWidth = 10
int adddressWidth = 25
int percentWidth = 5
String format = "%" + nameWidth + "s"
                    + "%" + rollNumberWidth + "s"
                    + "%" + addressWidth + "s"
                    + "%" + percentWidth + "s\n";
System.out.printf(format ,"Name", "Rollno", "Address", "Percentage");
while(rs.next())
{
    name = rs.getString(1);
    lname = rs.getString(2);
    address = rs.getString(3);
    city = rs.getString(4);
    System.out.printf(format , name, lname, address, city);
}