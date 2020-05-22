public class AutomatedAction extends DispatchAction implements ApplicationContextAware {

    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        MyAction myAction = (MyAction) getContext().getBean("/MyActionBean");
        myAction.myDispatch();
        // do more
        return null;
    }
}