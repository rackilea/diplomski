public class SpringAnnotationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
    return new Class[] { AppConfig.class };
}

@Override
protected Class<?>[] getServletConfigClasses() {
    // TODO Auto-generated method stub
    return null;
}

@Override
protected String[] getServletMappings() {
    // TODO Auto-generated method stub
    return null;
}
}