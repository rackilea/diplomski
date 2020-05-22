public void doGet(HttpServletRequest request,
                    HttpServletResponse response){

        // your request parsing

        // Your Magic with Selenium

        PrintWriter out = response.getWriter();
        String data = //your data fetched from website by `Selenium` library 
        out.println(//**html with embedded  data **//)
}