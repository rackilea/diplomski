public class RegistrationEmailCheck extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

      PrintWriter out = response.getWriter();
    JSONObject json = new JSONObject();
    String availEmail = request.getParameter("email");
    System.out.println(availEmail);
    String SQL = "SELECT email FROM login WHERE email='" + availEmail + "'";
    Connection con = DBInfo.getConn();
    Statement st;
    ResultSet rs;

    try {
        st = con.createStatement();
        rs = st.executeQuery(SQL);


        if (rs.next()) {

            out.print("{\"valid\" : false }");
            json.put("valid", false);
            System.out.println("false");


        } else {

            out.print("{\"valid\" : true }");
            json.put("valid", true);
            System.out.println("true");


        }


    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {

        out.close();
    }



}


}