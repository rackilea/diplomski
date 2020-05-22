String myCustomMsg="";  //You can return this variable as custom message.
try
{
    Connection con = GET_CONNECTION_HERE;
    PreparedStatement pstmt = con.prepareStatement("QUERY HERE");
    ResultSet rs = pstmt.executeQuery();
    if(rs.next())// This will make sure that if there is no data, don't read the ResultSet
    {
        System.out.println(rs.getString("MY_COLUMN_NAME"));
        myCustomMsg = "Ok";
    }
    else
        myCustomMsg ="No Data found!";
}
catch(SQLException sqle)
{
    sqle.printStackTrace();
    myCustomMsg ="YOUR CUSTOM MESSAGE HERE....";
}