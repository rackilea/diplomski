public class LoginFilter implements Serializable, Filter{
    private static final long serialVersionUID = 1L;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
//      HttpServletResponse res = (HttpServletResponse) response;

        HttpSession httpSession=req.getSession(true);
        Object administradorLogado=httpSession.getAttribute("administrador");
        System.out.println("Entrando no loginFileter!");

        if (administradorLogado == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/login.xhtml?faces-redirect=true");
            requestDispatcher.forward(request, response);
        }else{
            String url = ((HttpServletRequest)request).getRequestURL().toString();
            System.out.println("URL que peguei no filter admin: "+url);
            if(url.endsWith("admin/")){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/login.xhtml?faces-redirect=true");
                requestDispatcher.forward(request, response);
            }else{
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}