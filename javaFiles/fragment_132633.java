public class MyAction extends DispatchAction{

    public ActionForward myDispatch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        // Some code
        getSomeBD().doOperation();
    }
}