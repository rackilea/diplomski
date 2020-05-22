class Main extends HttpServlet{

Beanx bean =null;

 protected void doGet(HttpServletRequest request, HttpServletResponse response){
    try{

      bean=new Beanx();

      }catch(Exception e){
      //To do something
      }
 }
}