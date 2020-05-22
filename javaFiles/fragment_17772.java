String thisname=request.getParameter("username");
String thispwd=request.getParameter("password");

//Query for selecting user name and password from database.
String query = "select * from login where username=?";
pstmt = (PreparedStatement) con.prepareStatement(query);
pstmt.setString(1, thisname);
res = pstmt.executeQuery();

if(res.next())
{
    System.out.println("hhh");
    if ((thisname.equals(res.getString("username"))) && (thispwd.equals(res.getString("password"))))
    {
        System.out.println("hello");                                            
    }               
}else {
    System.out.println("in");
    session.invalidate();
    response.sendRedirect("index.html");
}