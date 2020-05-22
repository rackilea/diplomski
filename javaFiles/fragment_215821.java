@Override
protected WebResponse newWebResponse(WebRequest webRequest,
        HttpServletResponse httpServletResponse) {
    return new MyWebResponse((ServletWebRequest) webRequest,
            httpServletResponse);
}