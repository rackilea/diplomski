public class ViewPhaseListener implements PhaseListener {

    public void afterPhase(PhaseEvent phaseEvent)
    {

    }

    public void beforePhase(PhaseEvent phaseEvent)
    {
        HttpServletRequest request = ((HttpServletRequest) phaseEvent.getFacesContext().getExternalContext().getRequest());
        HttpSession session = request.getSession();

        session.setAttribute("com.sun.faces.renderkit.ServerSideStateHelper.LogicalViewMap", session.getAttribute("com.sun.faces.renderkit.ServerSideStateHelper.LogicalViewMap"));

    }

    public PhaseId getPhaseId()
    {
        return PhaseId.RENDER_RESPONSE;
          //To change body of implemented methods use File | Settings | File Templates.
    }
}