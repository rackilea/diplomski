protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String userinp = request.getParameter("userinp"); //hidden type in html sign up form
    HttpSession s = request.getSession();
    User u = new User();
    ServletContext ctx = s.getServletContext();
    //check for null first, because if userinp is empty, then you will get a NPE
    if(userinp != null && userinp.equals("signup")) {
        u.setName(request.getParameter("name"));
        u.setLname(request.getParameter("lname"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        s.setAttribute("User", u);
        //Save to DB
        u = (User)s.getAttribute("User");
        s.invalidate();
        UserM ud = new UserM(); //class which contains CRUD methods
        ud.createTable(); //why are you creating a table for each user? (you need to create a table called 'users' and just insert the new user there.
        ud.insert(u);

        forwardTo(ctx, request, response, "/Somepage.jsp");

    } else if( userinp != null && userinp.equals("login")) { //you should separate the register and login logic (easier to maintain in two different servlets
        String pass1 = request.getParameter("pass");
        String email = request.getParameter("useremail");


        //so instead of getting the password from the database, you can check to see if the details exist instead and return a boolean. 
        if(validate(email,pass1)){

        forwardTo(ctx, request, response, "/Welcome.jsp"); //user is logged in

        }else{

        forwardTo(ctx, request, response, "/Error.jsp"); //user is not logged in, details do not match

        }

    }

}