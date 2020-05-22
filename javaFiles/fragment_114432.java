public class showSchdulesAction extends ActionSupport     
     public String execute() throws Exception {
           ...
        HttpServletRequest request = ServletActionContext.getRequest();
        List list = someObj.getCommonList();
        if (list == null) list = new ArrayList(); 
        request.setAttribute("repTypList", list);
          ...
      }
  }