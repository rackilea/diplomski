public class AnnotationWebAppInitializer implements WebApplicationInitializer {

@Override
public void onStartup(ServletContext container) throws ServletException {
    // other configs

    container.addListener(SessionListener.class);

    // other configs
}