public void display(ActionRequest aReq, ActionResponse aResp){


    aReq.setAttribute("name",name);

    aResp.setRenderParameter("jspPage", "/new.jsp");
}