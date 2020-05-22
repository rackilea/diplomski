String name=request.getParameter("name");
        String password=request.getParameter("password");
        boolean status=false;
String role = "";
try{
    Connection con=ConnectionProvider.getCon();
    String sql="select * from roles where name='" + name + "' and pass='" + password";
    Statement stmt =con.createStatement();
    role ="admin";
    ResultSet rs=stmt.executeQuery(sql);
    if(rs.next())
    {
        status=true;
        role=rs.getString("role");
    }
}catch(Exception e){}

if(status){
            out.print("Welcome, "+name);
            HttpSession session=request.getSession();
            session.setAttribute("name",name);
            if(role!=null && role.equals("admin") ){            
            request.getRequestDispatcher("create.html").forward(request, response);
             //request.getRequestDispatcher("department.html").forward(request, response);
            }else{
             request.getRequestDispatcher("   <SomeOther>.html").forward(request, response);
             //request.getRequestDispatcher("department.html").forward(request, response);
          }

        }
        else{
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }