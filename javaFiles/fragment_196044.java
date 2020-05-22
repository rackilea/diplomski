public class CodebaseOverrider implements BeanFactoryPostProcessor {

    private List<String> sourceCodeLocations;

    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {        
        CodeBase codebase = (CodeBase)beanFactory.getBean("codebase");
        if (sourceCodeLocations != null)
        {
            codebase.setSourceCodeLocations(sourceCodeLocations);
        }
    }

    public void setSourceCodeLocations(List<String> sourceCodeLocations) {
        this.sourceCodeLocations = sourceCodeLocations;
    }

}