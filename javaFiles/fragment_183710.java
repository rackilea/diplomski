import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.ResultSet;
 import java.sql.SQLException;

 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 import sun.java2d.pipe.GeneralCompositePipe;

 import accessdb.Dao;
 import accessdb.Getset;

 /**
 * Servlet implementation class AdminLogIn
  */
 public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    String username=request.getParameter("username");
    System.out.println(""+username);

    String password=request.getParameter("password");
    System.out.println("test user"+username+"GGG"+password);
    if(username.equals("") || password.equals("") || username.equals(" ") || password.equals(" "))
    {
        response.sendRedirect("login.jsp");

    }
     else
     {
         try {
    Getset g=new Getset();
    Dao dao=new Dao();
    g.setuname(username);

     String newuname=username.substring(0,4);


     if(newuname.equals("engg"))
    { 

           ResultSet rs;
            rs = dao.EnggLogInCheck(g);
            while(rs.next())
            {
                String uname=rs.getString("uname");
                String password1=rs.getString("password");
                if(uname.equals(username) && (password.equals(password1)))
                {
                    response.sendRedirect("engghome.jsp");
                    break;
                }

            }

            if(rs.next()==false)
            {
                response.sendRedirect("login.jsp");
                return;
            }


    }

     else if(newuname.equals("empl"))
        { 

               ResultSet rs;
                rs = dao.EmplLogInCheck(g);
                while(rs.next())
                {
                    String uname=rs.getString("uname");
                    String password1=rs.getString("password");
                    if(uname.equals(username) && (password.equals(password1)))
                    {
                        response.sendRedirect("empcmp.jsp");
                        break;
                    }

                }

                if(rs.next()==false)
                {
                    response.sendRedirect("login.jsp");
                    return;
                }


        }
     else if(username.equals("system"))
        { 

               ResultSet rs;
                rs = dao.LogInAdmin(g);
                while(rs.next())
                {

                    String password1=rs.getString(1);
                    if(password.equals(password1))
                    {
                        response.sendRedirect("adminhome.jsp");System.out.println("ffffff");
                        break;
                    }
                    else
                    {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                }




           }


     else 
           {
               response.sendRedirect("login.jsp");
               return;

           }



     }
       catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}
}
    }