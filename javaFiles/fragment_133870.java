public static String getFormTagRenderFormStartElement(PageContext pageContext, String formStartElement, WindowState ws)
{
    if ( PortletServlet.isPortletRequest(pageContext.getRequest()))
    {
        int actionURLStart = formStartElement.indexOf("action=") + 8;
        int actionURLEnd = formStartElement.indexOf('"', actionURLStart);
        String actionURL = formStartElement.substring(actionURLStart,
                actionURLEnd);
      final PortletURL portletURL = StrutsPortletURL.createActionURL(pageContext.getRequest(),
                                                                    actionURL);
      if (ws!=null) {
        try {
          portletURL.setWindowState(ws);
        }
        catch (WindowStateException e) {
          e.printStackTrace();
        }
      }
      formStartElement = formStartElement.substring(0, actionURLStart)
                + portletURL.toString()
                + formStartElement.substring(actionURLEnd);
    }
    return formStartElement;
}