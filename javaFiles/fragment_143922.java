...
public class ActionServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public ActionServlet() {
      // TODO Auto-generated constructor stub
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String answer = "Something went Wrong";
      String userinput = request.getParameter("userinput").toString();

      HttpSession httpSession = request.getSession(true);
      if(httpSession.isNew()) {
         httpSession.setAttribute("sessionVar", new ArrayList<String>());
      }

      List<String> arrayList = (ArrayList<String>)httpSession.getAttribute("sessionVar");
      if(userinput != null && !userinput.equals("")) {
         if(arrayList.contains(userinput)) {
            answer = "Email already taken!";
         } else {
            arrayList.add(userinput);
            answer = "Email available";
         }
      }

     response.setContentType("text/plain");  
     response.setCharacterEncoding("UTF-8"); 
     response.getWriter().write(answer); 
   } 
   ...