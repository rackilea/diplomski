droplet.java

public void service(DynamoHttpServletRequest request, DynamoHttpServletResponse response) 
    throws ServletException, IOException
{
    boolean handled = false;
    String b = (String) request.getParameter("a");

    if(b != null && b.equals("c")){
        handled = request.serviceLocalParameter("d", request, response);
    }else{
        handled = request.serviceLocalParameter("e", request, response);
    }

    /*
     * Did not find a valid parameter, try servicing the
     * parameter named "default" instead
     */
    if (!handled) {
        request.serviceLocalParameter("default", request, response);
    }
}