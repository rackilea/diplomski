public class SpELFunctionBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.setBeanExpressionResolver(new StandardBeanExpressionResolver() {

            @Override
            protected void customizeEvaluationContext(StandardEvaluationContext evalContext) {
                evalContext.registerFunction("ioToString",
                        IOUtils.class.getDeclaredMethod("toString", new Class[] { FileReader.class }));
            }

        });
    }

}