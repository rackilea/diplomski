import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WSTutorial extends HttpServlet {


    private int temp;
    private String fromUnit;
    private String toUnit;

    public void init() throws ServletException {
    // Do required initialization

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        temp = Integer.parseInt(request.getParameter("temperature"));
        fromUnit = request.getParameter("fromUnit");
        toUnit = request.getParameter("toUnit");

         out.println("<h1> Temp is " + convertTemp(temp ,fromUnit,toUnit) + "</h1>");
out.close();
        }

    private static double convertTemp(java.lang.String temperature, java.lang.String fromUnit, java.lang.String toUnit) {
        net.webservicex.ConvertTemperature service = new net.webservicex.ConvertTemperature();
        net.webservicex.ConvertTemperatureHttpGet port = service.getConvertTemperatureHttpGet();
        return port.convertTemp(temperature, fromUnit, toUnit);
    }

}