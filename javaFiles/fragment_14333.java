Connection con = null;
    String URL="jdbc:derby://localhost:1527/Bank Database";
    PreparedStatement ps = null;
    ResultSet rs = null;
    String qry="SELECT * FROM DATABASE WHERE BANK=? AND CARD_NO=? AND PASWORD=?";
    try {
        con = DriverManager.getConnection(URL,"Bank","Bank");
        ps = con.prepareStatement(qry);

        //set the parameter
        ps.setString(1, bname);
        ps.setString(2, cname);
        ps.setString(3, pswrd);
        rs = ps.executeQuery();

        if (rs.next()) {
            out.println("<script>function redirect(){ window.location=\"scsfl.html\";} setTimeout('redirect()',3000);</script>");  //redirects to another page 
        } else {
            out.println("<script>function redirect(){ window.location=\"failed.html\";} setTimeout('redirect()',3000);</script>");
        }
    } finally {
        if (rs != null)
            rs.close();
        ps.close();
        con.close();
    }