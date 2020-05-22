public class VirtualBeanProductIdPropertyWriter extends VirtualBeanPropertyWriter {

    public VirtualBeanProductIdPropertyWriter() {
    }

    public VirtualBeanProductIdPropertyWriter(BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType)
    {
        super(propDef, contextAnnotations, declaredType);
    }

    @Override
    protected Object value(Object bean, JsonGenerator jgen, SerializerProvider prov) throws Exception {
        if(bean instanceof AbstractPersistentObject) {
            return ((AbstractPersistentObject) bean).getId();
        }
        return null;
    }

    @Override
    public VirtualBeanPropertyWriter withConfig(MapperConfig<?> config, AnnotatedClass declaringClass, BeanPropertyDefinition propDef, JavaType type) {
        return new VirtualBeanProductIdPropertyWriter(propDef, null, type);
    }
}