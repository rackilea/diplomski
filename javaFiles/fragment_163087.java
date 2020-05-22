@Configuration
public class UrlRewriteConfig extends UrlRewriteFilter {

    private UrlRewriter urlRewriter;

    @Bean
    public FilterRegistrationBean tuckeyRegistrationBean() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new UrlRewriteConfig());
        return registrationBean;
    }

    @Override
    public void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
        try {
            ClassPathResource classPathResource = new ClassPathResource("urlrewrite.xml");
            InputStream inputStream = classPathResource.getInputStream();
            Conf conf1 = new Conf(filterConfig.getServletContext(), inputStream, "urlrewrite.xml", "");
            urlRewriter = new UrlRewriter(conf1);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public UrlRewriter getUrlRewriter(ServletRequest request, ServletResponse response, FilterChain chain) {
        return urlRewriter;
    }

    @Override
    public void destroyUrlRewriter() {
        if (urlRewriter != null)
            urlRewriter.destroy();
    }
}