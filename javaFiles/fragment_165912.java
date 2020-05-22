public class YourServlet extends HttpServlet {

    Timer timer;
    HttpServletResponse response;   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)...{
        int seconds = 5;
        timer = new Timer();
        timer.schedule(new DeadLine(), seconds * 1000);     

        /* the rest of your code here */
    }

    class DeadLine extends TimerTask {
        public void run() {      
            response.getWriter().print("Error: deadline reached.");     
        }
      }
}