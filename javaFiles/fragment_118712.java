public class WebContextTestExecutionListener extends
            AbstractTestExecutionListener {

        @Override
        public void prepareTestInstance(TestContext testContext) throws Exception {

            if (testContext.getApplicationContext() instanceof GenericApplicationContext) {
                GenericApplicationContext context = (GenericApplicationContext) testContext.getApplicationContext();
                ConfigurableListableBeanFactory beanFactory = context
                        .getBeanFactory();
                Scope requestScope = new SimpleThreadScope();
                beanFactory.registerScope("request", requestScope);
                Scope sessionScope = new SimpleThreadScope();
                beanFactory.registerScope("session", sessionScope);
                Scope threadScope= new SimpleThreadScope();
                beanFactory.registerScope("thread", threadScope);
            }
        }
    }