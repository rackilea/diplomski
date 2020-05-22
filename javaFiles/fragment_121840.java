public class DemoServlet extends HttpServlet
{
   private final someParam; //someParam is final once set cannot be changed

   //default constructor called by the runtime.
   public DemoServlet()
   {
       //constructor-chained to the paramaterized constructor
       this(1);
   }

   //observe carefully that this paramaterized constructor has only
  //package-level visibility. This is useful for being invoked through your
  //  unit and functional tests which would typically reside within the same 
  //package. Would also allow your test code to inject required values to 
 //verify behavior while testing.
   DemoServlet(int someParam)
   {
      this.param = param
   }

   //... Other class code...
}