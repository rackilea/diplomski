public class MissingGenericBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (!metadata.isAnnotated(ConditionalOnMissingGenericBean.class.getName()) || context.getBeanFactory() == null) {
            return false;
        }
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnMissingGenericBean.class.getName());
        Class<?> containerType = (Class<?>) attributes.get("containerType");
        Class<?>[] typeParameters = (Class<?>[]) attributes.get("typeParameters");

        ResolvableType resolvableType;
        if (Void.class.equals(containerType)) {
            if (!(metadata instanceof MethodMetadata) || !metadata.isAnnotated(Bean.class.getName())) {
                throw error();
            }
            //When resolving beans within the starter
            if (metadata instanceof StandardMethodMetadata) {
                resolvableType = ResolvableType.forType(((StandardMethodMetadata) metadata).getIntrospectedMethod().getGenericReturnType());
            } else {
                //When resolving beans in an application using the starter
                MethodMetadata methodMeta = (MethodMetadata) metadata;
                try {
                    // This might not be a safe thing to do. See the notes below.
                    Class<?> declaringClass = ClassUtils.forName(methodMeta.getDeclaringClassName(), context.getClassLoader());
                    Type returnType = Arrays.stream(declaringClass.getDeclaredMethods())
                            .filter(m -> m.isAnnotationPresent(Bean.class))
                            .filter(m -> m.getName().equals(methodMeta.getMethodName()))
                            .findFirst().map(Method::getGenericReturnType)
                            .orElseThrow(MissingGenericBeanCondition::error);
                    resolvableType = ResolvableType.forType(returnType);
                } catch (ClassNotFoundException e) {
                    throw error();
                }
            }
        } else {
            resolvableType = ResolvableType.forClassWithGenerics(containerType, typeParameters);
        }

        String[] names = context.getBeanFactory().getBeanNamesForType(resolvableType);
        return names.length == 0;
    }

    private static IllegalStateException error() {
        return new IllegalStateException(ConditionalOnMissingGenericBean.class.getSimpleName()
                + " is missing the explicit generic type and the implicit type can not be determined");
    }
}