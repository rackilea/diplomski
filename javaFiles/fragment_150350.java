@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

 String val  =  request.getParameter("VAL");
 bean Mybean= new bean();
 Mybean.NewVal(val, 0);
 System.out.println("--------------------"+Mybean.getVal(0));
}