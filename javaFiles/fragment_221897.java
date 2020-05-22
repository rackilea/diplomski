private String getURL()
{
    Enumeration<String> lParameters;
    String sParameter;
    StringBuilder sbURL = new StringBuilder();
    Object oRequest = FacesContext.getCurrentInstance().getExternalContext().getRequest();

    try
    {
        if(oRequest instanceof HttpServletRequest)
        {
            sbURL.append(((HttpServletRequest)oRequest).getRequestURL().toString());

            lParameters = ((HttpServletRequest)oRequest).getParameterNames();

            if(lParameters.hasMoreElements())
            {
                if(!sbURL.toString().contains("?"))
                {
                    sbURL.append("?");
                }
                else
                {
                    sbURL.append("&");
                }
            }

            while(lParameters.hasMoreElements())
            {
                sParameter = lParameters.nextElement();

                sbURL.append(sParameter);
                sbURL.append("=");
                sbURL.append(URLEncoder.encode(((HttpServletRequest)oRequest).getParameter(sParameter),"UTF-8"));

                if(lParameters.hasMoreElements())
                {
                    sbURL.append("&");
                }
            }
        }
    }
    catch(Exception e)
    {
        // Do nothing
    }

    return sbURL.toString();
}