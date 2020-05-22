@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected String[] getServletMappings() {
    return new String[ ] { "/" };
}

@Override
protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[ ] { AppConfig.class, SecurityConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[ ]{ MvcServletConfig.class };
}
}