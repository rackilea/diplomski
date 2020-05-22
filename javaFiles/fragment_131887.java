/**
 * Returns <code>true</code> if the session cookie set by the login form
 * is not present.
 * 
 * @param request The HTTP request being processed
 * @return <code>true</code> if JavaScript is disabled, otherwise <code>false</code>
 */
private boolean isJavaScriptDisabled(HttpServletRequest request)
{
  boolean isJavaScriptDisabled = true;
  Cookie[] cookies = request.getCookies();

  if (cookies != null)
  {
    for (int i = 0; i < cookies.length; i++)
    {
      if ("JavaScriptEnabledCheck".equalsIgnoreCase(cookies[i].getName()))
      {
        isJavaScriptDisabled = false;
        break;
      }
    }
  }

  return isJavaScriptDisabled;
}