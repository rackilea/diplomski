@WebServlet("/organizer")
public class UserLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) 
         throws ServletException, IOException {

        doPost(request, response);
    }

    @SuppressWarnings("Duplicates")
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) 
         throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = getUsert(emil password)

        if(user != null){
            request.setAttributes("eventCount", getEventsCount(email, password));
            request.setAttributes("affiliateCount", getAffiliatesCount(email,password));
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        }else{
            request.setAttribute("failedLogin", true);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected User getUser(String email  String password){}

        User user = null; //create a class user with 3 fields

        //qeuery

        if(rs.next()){
            user = new User(rs.getInt("id"), 
                                rs.getString("firstname"), 
                                    rs.getString("lastname"))
        }

        return user;
    }

    protected int getEventsCount(String email, String password)
            throws ServletException, IOException {
        //query and return result
        return count;
    }

    protected void getAffiliatesCount(String email, String password)
            throws ServletException, IOException {
        //query and return result
        return count;
    }
}