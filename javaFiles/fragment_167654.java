public class ApplicationContextMock implements ApplicationContext {
    private Map<String, Object> beans;

    public ApplicationContextMock() {
        beans = new HashMap<String, Object>();
        beans.put("child1", new SomeServiceMock());
        beans.put("child2", new AnotherServiceMock());
    }

    public Object getBean(String arg0) throws BeansException {
        return beans.get(arg0);
    }
    // ...
}