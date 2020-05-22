public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
       return new Class<?>[]{

        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}