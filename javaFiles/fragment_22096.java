Exception e = new NullPointerException("something ...");
    // copied from BasicErrorPaneUI
    StringBuffer html = new StringBuffer("<html>");
    html.append("<h2>" + "Error" + "</h2>");
    html.append("<HR size='1' noshade>");
    html.append("<div></div>");
    html.append("<b>Message:</b>");
    html.append("<pre>");
    html.append("    " + e.toString());
    html.append("</pre>");
    html.append("<b>Level:</b>");
    html.append("<pre>");
    html.append("    " + ErrorLevel.SEVERE);
    html.append("</pre>");
    html.append("</html>");

    ErrorInfo errorInfo = new ErrorInfo("Error", e.getMessage(), 
            html.toString(), null, e, ErrorLevel.SEVERE, null);
    JXErrorPane.showDialog(null, errorInfo);