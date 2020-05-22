public static String getURL(PageContext pageContext, String url, PortletURLTypes.URLType type, WindowState ws)
...
    if ( type.equals(PortletURLTypes.URLType.ACTION) )
    {
      final PortletURL portletURL = StrutsPortletURL.createActionURL(pageContext.getRequest(), url);
      if (ws!=null) {
        try {
          portletURL.setWindowState(ws);
        }
        catch (WindowStateException e) {
          e.printStackTrace();
        }
      }
      return portletURL.toString();
    }
    else if ( type.equals(PortletURLTypes.URLType.RENDER) )
    {
      final PortletURL portletURL = StrutsPortletURL.createRenderURL(pageContext.getRequest(), url);
      if (ws!=null) {
        try {
          portletURL.setWindowState(ws);
        }
        catch (WindowStateException e) {
          e.printStackTrace();
        }
      }
      return portletURL.toString();
    }
...