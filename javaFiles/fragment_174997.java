public <T> String[] getProperties(T entity){
    String[] properties = null;
    try {
        BeanInfo entityInfo = Introspector.getBeanInfo(entity.getClass());
        PropertyDescriptor[] propertyDescriptors = entityInfo.getPropertyDescriptors();
        properties = new String[propertyDescriptors.length];
        for(int i = 0 ; i < propertyDescriptors.length ; i++){
            Object propertyValue = propertyDescriptors[i].getReadMethod().invoke(entity);
            if(propertyValue != null){
                properties[i] = propertyValue.toString();
            } else {
                properties[i] = null;
            }
        }
    } catch (Exception e){
        //Handle your exception here.
    }
    return properties;
}