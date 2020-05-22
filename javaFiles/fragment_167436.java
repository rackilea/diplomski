@Inject
@Any
Instance<Object> myBeans;

public Object getMyBeanFromClassName(String className) throws Exception{    
    Class clazz = Class.forName(className);
    return myBeans.select(clazz).get();  
}