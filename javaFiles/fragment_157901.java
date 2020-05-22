public void doFilter(ServletRequest req, ServletResponse resp,
                     FilterChain chain)
{
    // ...

    if (req.getParameter(MY_PARAMNAME) != null)
        chain.doFilter(req, resp);
    // otherwise don't call doFilter

    // ...
}