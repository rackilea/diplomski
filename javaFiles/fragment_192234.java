public class AuthenticationFilter implements Filter {

    SessionFactory sessionFactory;   

    @Override
    public void destroy() {
        this.sessionFactory.close();
        this.sessionFactory = null;    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    if(httpRequest.getParameter("username") != null 
            && httpRequest.getParameter("password") != null)
    {
        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");
        boolean rememberMe = false;
        if(httpRequest.getParameter("rememberMe")!= null)
            rememberMe = httpRequest.getParameter("rememberMe").equals("on");

        UserInfo user = getUserInfo(username, password);
         System.out.print(user+"\n"+rememberMe);

    }
    chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
        this.sessionFactory = ctx.getBean(SessionFactory.class);
    }

    public UserInfo getUserInfo(String username, String password)
    {
        UserInfo user=null;
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM UserInfo WHERE"
                + " UserInfo.username = :xusername AND UserInfo.password = :xpassword");
        query.setParameter("xusername",username);
        query.setParameter("xpassword",password);
        List list=query.getResultList();
        if (list.size()>0)
            user=(UserInfo)list.get(0);
        return user;
    }

}