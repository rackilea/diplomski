public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
.
.
.
    @Override
    public void onStartup(ServletContext container) throws ServletException
    {
        super.onStartup(container);
        container.addListener(Initializer.class);
    }
}