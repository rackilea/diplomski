public class SifBeanSerializerModifier extends BeanSerializerModifier {
public List<BeanPropertyWriter> changeProperties(SerializationConfig config,
        BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {

        Class cc = beanDesc.getType().getRawClass();      
        Method m;
        try {
            m = cc.getMethod("getClass", null);
            TypeResolutionContext.Basic tb = new TypeResolutionContext.Basic(TypeFactory.defaultInstance(), TypeBindings.emptyBindings());
            AnnotatedMethod am = new AnnotatedMethod(tb, m, _emptyAnnotationMap(), null);
            BeanPropertyDefinition propDef = SimpleBeanPropertyDefinition.construct(config, am, JacksonExtConstants.JAVA_CLASS_NAME_KEY);
            BeanPropertyWriter beanPropWriter = new BeanPropertyWriter(propDef,
                        am, null,
                        SimpleType.constructUnsafe(Class.class),
                        null, null, SimpleType.constructUnsafe(Class.class),
                        true, null);

            beanProperties.add(beanPropWriter);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
    return beanProperties;
}


private AnnotationMap _emptyAnnotationMap() {
    return new AnnotationMap();
}