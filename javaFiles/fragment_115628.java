public void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
     //getting paramValue
    ServletConfig config=getServletConfig();  
    String driver=config.getInitParameter("paramName"); 
    }