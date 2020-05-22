@WebServlet("/populate")
   public class PopulateData extends HttpServlet{

      public void doGet(....){
         Class.forName("org.postgresql.Driver");
         Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost/test","root", "root!");

        Statement s = con.createStatement();
        String sql ="SELECT USERS FROM ACCOUNT";
        ResultSet rs = s.executeQuery(sql);

        List<String> list = new ArrayList<String>();

        while (rs.next()) {
          list.add(rs.getString("USERS"));
        }
       String json = new Gson().toJson(list);
       response.getWriter().write(json);
      }
  }