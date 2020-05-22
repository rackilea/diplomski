@Override
public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
/** You will want to check your array of values and have this data cached  **/
if (urlPath.contains("/sectionName")) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sections" + "/" + urlPath);
        requestDispatcher.forward(request, response);
    }

}