@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            /*
             * This code puts the value "userName" to the Mapped Diagnostic
             * context. Since MDc is a static class, we can directly access it
             * with out creating a new object from it. Here, instead of hard
             * coding the user name, the value can be retrieved from a HTTP
             * Request object.
             */
            MDC.put("userName", req.attribute("executor"));
            MDC.put("date", System.currentTimeMilis());
            MDC.put("role", getRole()); 
            //Any other properties you want to set
            chain.doFilter(request, response);

        } finally {
            MDC.remove("userName");
        }
    }