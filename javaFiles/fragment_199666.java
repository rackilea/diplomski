public class BaseAction extends ActionSupport implements ServletRequestAware {

protected HttpServletRequest request = null;


@Override
public void setServletRequest(HttpServletRequest request) {
    this.request = request;
}

@Override
public String execute() throws Exception {
   String id= request.getParameter("id");
   result = "\"{\"age\":100,\"name\":\"dude\"}"; 

   return SUCCESS;
}

}