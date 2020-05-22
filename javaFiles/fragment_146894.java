public class EmployeeLoadAction extends Action{
    private final static String SUCCESS = "success";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        ActionForward forward;
        forward = mapping.findForward(SUCCESS);
        saveToken(request);
        return forward;
    }
}