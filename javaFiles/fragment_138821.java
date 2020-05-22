public class Output extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

     Predicts p = new Predicts();
     p.predict();
}
}