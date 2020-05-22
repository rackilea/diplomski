ExecutionContext executionContext = smooks.createExecutionContext();

MappingStaticParams staticParams = new MappingStaticParams();
staticParams.setSomeTextParam = "someValue";
BeanId beanId = executionContext.getBeanContext().getBeanId("staticParams");
executionContext.getBeanContext().addBean(beanId, staticParams );