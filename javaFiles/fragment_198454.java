public class User{

  String username;
  String url;

    //getter and setter methods
}


...

public class PrintMsgAction extends Action{

  public ActionForward execute(ActionMapping mapping,ActionForm form,
      HttpServletRequest request,HttpServletResponse response) 
        throws Exception {

      List<User> listUsers = new ArrayList<User>();

      listUsers.add(new User("user1", "http://www.user1.com"));
      listUsers.add(new User("user2", "http://www.user2.com"));
      listUsers.add(new User("user3", "http://www.user3.com"));
      listUsers.add(new User("user4", "http://www.user4.com"));

      request.setAttribute("listUsers", listUsers);

      return mapping.findForward("success");
  }

}