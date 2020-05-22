public class AdditionalPropertiesBeanPostProcessor
implements BeanPostProcessor{

    private Map<String, Map<String, Object>> propertiesMap;

    public void setPropertiesMap(
        final Map<String, Map<String, Object>> propertiesMap){
        this.propertiesMap = propertiesMap;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean,
        final String beanName) throws BeansException{
        final Map<String, Object> props = propertiesMap.get(beanName);
        if(props != null){
            final BeanWrapper bw = new BeanWrapperImpl(bean);
            for(final Entry<String, Object> entry : props.entrySet()){
                bw.setPropertyValue(entry.getKey(), entry.getValue());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean,
        final String beanName) throws BeansException{
        return bean;
    }

}