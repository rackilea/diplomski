package testPackage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/carServlet")
public class CarServlet extends HttpServlet 
{
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String carName = request.getParameter("car_name");
        System.out.println("Car Name:" + carName);
   }
}