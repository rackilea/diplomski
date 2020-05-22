public class AppInitializer implements WebApplicationInitializer {

public void onStartup(ServletContext container) throws ServletException {

    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(AppConfig.class);
    ctx.setServletContext(container);

}
}