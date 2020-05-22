public class AppInitialzer extends AbstractAnnotationConfigDispatcherServletInitializer {

    ...    

    protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
        return new ApplicationContextInitializer[] { new SpringAppContInit() } ;
    }
}