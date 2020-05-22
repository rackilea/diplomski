protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("pass");

    try {
        connection = Connector.ConnectDb();
        PreparedStatement pst = connection.prepareStatement("SELECT * FROM Company WHERE Email= '"+email+"'");

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            if (BCrypt.checkpw(password, rs.getString("Password"))) {
                ...