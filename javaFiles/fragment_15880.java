import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.demo.model.Authenticate;


public class LoginController extends HttpServlet {

    private static final long SerialVersionUID=1L;

    public LoginController()
    {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String s1=req.getParameter("username");
        String s2=req.getParameter("password");
        RequestDispatcher rd=null;

        Authenticate au=new Authenticate();
        String result=au.authorise(s1, s2);

        if(result.equals("success"))
        {
            rd=req.getRequestDispatcher("/success.jsp");

//The error was with this line
            rd.forward(req, resp);
        }
        else
        {

            PrintWriter out = resp.getWriter(  );
            out.print("Sorry UserName or Password Error!");
            rd=req.getRequestDispatcher("/login.html");  
            rd.include(req, resp);  

        }

    }

}