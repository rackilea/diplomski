@Override
protected WebResponse newWebResponse( WebRequest webRequest, HttpServletResponse httpServletResponse )
{
    WebResponse response = super.newWebResponse( webRequest, httpServletResponse );
    //Protect against clicjJacking:
    // See https://developer.mozilla.org/en-US/docs/Web/HTTP/X-Frame-Options
    // and http://blogs.msdn.com/b/ieinternals/archive/2010/03/30/combating-clickjacking-with-x-frame-options.aspx
    response.addHeader( "X-Frame-Options", "SAMEORIGIN" );
    return response;
}