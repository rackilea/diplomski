ResultSet rs=stm.executeQuery(sqlQuery); // this is returning 5 elements

while(rs.next()) {
    String unamedb=rs.getString("username");
    String pworddb=rs.getString("password");
    String tofdb=rs.getString("typeof");
    if(fieldtxtname.equals ("")||fieldtxtpw.equals ("")||fieldtxtutype.equals ("")){
        System.out.println("The fields are not filled properly.");
        break;
// you might want to break the loop if the fields are empty in db
    } else if(fieldtxtname.equals(unamedb)&&fieldtxtpw.equals(pworddb)&&fieldtxtutype.equals(tofdb)) {
        System.out.println("Access granted");
        break;
// you might want to break the loop once the username, passwrod is found for access to be granted
    } else {
        System.out.println("Unknown username"); // just to display information
    }
}