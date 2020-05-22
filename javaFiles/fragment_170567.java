public static <T extends Object> T setFromMap(Class<T> beanClazz, HashMap<String, String> propValues) throws Exception  
{  
    T bean = (T) beanClazz.newInstance();  
    Object obj = new Object();  
    PropertyDescriptor[] pdescriptors = null;  
    BeanInfo beanInfo = Introspector.getBeanInfo(beanClazz);  
    pdescriptors = beanInfo.getPropertyDescriptors();  
    for(int i=0; i<pdescriptors.length; i++)  
    {  
        String descriptorName = pdescriptors[i].getName();  
        if(!(descriptorName.equals("class")))  
        {  
            String propName = descriptorName;  
            String value = (String) propValues.get(propName);  
            if(value != null)  
            {  
                Object[] objArray = new Object[1];  
                objArray[0] = value;  
                Method writeMethod = pdescriptors[i].getWriteMethod();  
                writeMethod.invoke(bean, objArray);  
            }  
        }  
    }
    return bean;
}