public class DispatcherConf extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConf.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConf.class}; // !!!
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/*"};
    }
}