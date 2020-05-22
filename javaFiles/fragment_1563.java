protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            // reading the user input 
            out.append("<ul>");
            for(User user: data.getUsers())
            {
                out.append("<li>" +user.getFirstName()+" "+user.getLastName()
                        +"<br>Address:"+user.getAddress()
                        +"<br>Age:"+user.getAge()+"</li>");
            }
            out.append("</ul>");
        }
    }