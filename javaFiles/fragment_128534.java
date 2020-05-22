public class BookActionDo extends DispatchAction {

 public ActionForward edit(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
                throws Exception {
    String actionTarget = null;

    HttpSession session = request.getSession();

    Book book = new Book();
    BookForm uf = (BookForm) form;

    //Check the id
    if(!uf.validateId(mapping, request).isEmpty()){
        actionTarget = "invalidId";

        ActionRedirect redirect = new ActionRedirect(mapping.findForward(actionTarget));
        return redirect;
    }

    ActionErrors actionErrors = uf.validate(mapping, request);
    int id = Integer.parseInt(request.getParameter("id"));

    //If there are some errors, redirect to the form page
    if(!actionErrors.isEmpty()){
        actionTarget = "editErrors";

        session.setAttribute("errors", actionErrors);
        session.setAttribute("form", uf);

        ActionRedirect redirect = new ActionRedirect(mapping.findForward(actionTarget));
        redirect.addParameter("id", Integer.toString(id));
        return redirect;
    }

    if(form != null){
        book = new Book(uf);
        book.setId(id);

        try{
            int bookId = (int) BookDAO.update(book);

        }catch(Exception e){
            actionTarget = "editFailed";
        }
    }

    return mapping.findForward(actionTarget);
 }
}