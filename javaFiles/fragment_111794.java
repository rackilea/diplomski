protected void doPost(...) throws ServletException, IOException {
    String email = request.getParameter("email");
    String passwd = request.getParameter("pwd");
    Connection connection = ConnectionProvider.getConnection();
    new ConnectionProvider().authenticate(connection,email ,passwd);    

}