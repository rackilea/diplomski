import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderServlet
*/
@WebServlet("/RequestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public RequestHeaderServlet() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Enumeration en = request.getHeaderNames();
    while(en.hasMoreElements()){

        //get header name Accept,Accept-Charset,Authorization,Connection,Host etc.   
        String headerName = (String) en.nextElement(); //nextElement() returns Object need type cast

        //get the value of the headerName 
        String headerValue = request.getHeader(headerName);

        //display on browser
        out.print("Header Name = "+ headerName + " " + " Header Value = "+ headerValue + "<br>");

    }
out.close();
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
 }
}