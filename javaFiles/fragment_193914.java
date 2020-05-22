protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    // To get confirmation that the servlet gets the values of n1 , n2
    System.out.println("n1 : "+request.getParameter("n1"));
    System.out.println("n2 : "+request.getParameter("n2"));

    int num1 = Integer.parseInt(request.getParameter("n1"));
    int num2 = Integer.parseInt(request.getParameter("n2"));

    out.println(num1+num2+"");


}