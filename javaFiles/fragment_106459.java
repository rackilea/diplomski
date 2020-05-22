@Autowired
private  AutowireCapableBeanFactory autowireCapableBeanFactory;

public void doSomething(Map<String, Object> value) throws Exception {
    ObjectMapper om = new ObjectMapper();
    SimpleClass bean = om.convertValue(value, SimpleClass.class);
    autowireCapableBeanFactory.autowireBean(bean);
    bean.doSomethingFromService();
}