String queryString =request.getQueryString();
       // PrintWriter out = response.getWriter();
       // out.println(request.getQueryString());  

        //check where to redirect
        if (queryString.equals("roster")) {
            //redirect to Roster Upload jsp
            request.getRequestDispatcher("/WEB-INF/FOLDER/Roster.jsp").forward(request, response);
        } else if (queryString.equals("manual")) {
            //redirect to Manual Generation jsp
            request.getRequestDispatcher("/WEB-INF/FOLDER/ManualOrder.jsp").forward(
                request, response);
        }