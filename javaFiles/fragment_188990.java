private int counter;

private Object lock;

public void init() throws ServletException{
  //init lock
  lock = new Object();
  // create variable 
  counter = 0;
}


public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  //increment your counter here
  synchronized(lock){
  counter++;
  }
  response.setContentType("text/html");

  // here you can actually return the counter to the browser.
  PrintWriter out = response.getWriter();
  out.println("<h1>" + counter + "</h1>"); 
}