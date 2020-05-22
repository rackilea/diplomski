public void init(FilterConfig filterConfig)
{
    // ...

    // use this value in your doFilter method, in place of MY_PARAMNAME, above
    this.requiredParameterName =
        filterConfig.getInitParameter("required_parameter_name");
}