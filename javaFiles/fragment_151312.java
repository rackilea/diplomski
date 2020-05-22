public class GlobalevEventPhaseListener implements PhaseListener {
  public void beforePhase(final PhaseEvent event) {
    final FacesContext facesContext = event.getFacesContext();
    final HttpSession httpSession =   
        JSFUtil.getHttpSession(facesContext);

    if (httpSession != null) {
      final List globalEvents = getGlobalEvents(httpSession);

      if (!globalEvents.isEmpty()) {
        fireEvents(globalEvents);
      }
    }
  }

  private void fireEvents(final List globalEvents) {
    final BeanManager beanManager = lookBeanManager();

    if (beanManager != null) {
      try {
        for (final GlobalEvent devaGlobalEvent : globalEvents) {
          beanManager.fireEvent(devaGlobalEvent);
        }
      } catch (final Exception e) {
        throw new IllegalStateException("fireEvents", e);
      }
    }
  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.RENDER_RESPONSE; // RESTORE_VIEW;
  }

  private BeanManager lookBeanManager() {
    try {
      final Object obj = 
        new InitialContext().lookup("java:comp/BeanManager");

      return (BeanManager) obj;
    } catch (final Exception e) {
           throw new 
            IllegalStateException("Lookup bean manager", e);
    }

    return null;
  }

  private synchronized List getGlobalEvents(final HttpSession httpSession) {
    final List events = (List) httpSession.getAttribute(
        GlobalevHttpSessionController.EVENT_ATTRIBUTE_NAME);
    final List result = new ArrayList();

    if (events != null) {
      result.addAll(events);
      events.clear();
    }

    return result;
  }
}