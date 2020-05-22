getServletContext().getRequestDispatcher(newUrl).forward(request, new HttpServletResponseWrapper(response) {
    @Override
    public String encodeURL(String url) {
        String contextPath = getServletContext().getContextPath();
        if (url.startsWith(contextPath))
            url = new StringBuilder(url).insert(contextPath.length(), "/" + getLocale().getLanguage()).toString();
        return super.encodeURL(url);
    }
});