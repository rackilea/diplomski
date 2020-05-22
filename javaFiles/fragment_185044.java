public class MapImageServlet extends HttpServlet {
//... constructor and other methods ...
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // OPTIONAL PARAMETERS
     boarderSize = ParamUtil.getDoubleValue(request,"boarderSize", defaultValue);

     boarderThickness = ParamUtil.getDoubleValue(request, "boarderThickness", defaultValue);

     boarderColor = ParamUtil.getDoubleValue(request,"boarderColor" , defaultValue);
     //... do stuff with the parameters ...
}

}
public class ParamUtil
{
public static double getDoubleValue(ServletRequest request, String paramName, double defaultValue)
{
     if(request.getParameter(paramName) != null){
        return Double.valueOf(request.getParameter(paramName));
    } else{
        return defaultValue;
    }
}
}