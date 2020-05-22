public class EmployeeSubmitAction extends Action{
    private final static String SUCCESS = "success";
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        ActionForward forward;
        forward = mapping.findForward(SUCCESS);
        EmployeeSubmitForm frm = (EmployeeSubmitForm) form;
        if (isTokenValid(request)) {
            System.out.println("frm.getName() : " + frm.getEmpName());
            resetToken(request);
        } else {
            System.out.println("frm.getName() : " + frm.getEmpName());
            System.out.println("Duplicate Submission of the form");
        }
        return forward;
    }
}