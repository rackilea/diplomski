public class CustomMetadataMBeanInfoAssembler extends MetadataMBeanInfoAssembler {

    private String getName(final Method method) {
        final JmxName annotation = method.getAnnotation(JmxName.class);
        if (annotation != null) {
            return annotation.value();
        }else
            return method.getName();
        }
    }
    protected ModelMBeanOperationInfo createModelMBeanOperationInfo(Method method, String name, String beanKey) {
            return new ModelMBeanOperationInfo(getName(method),
                getOperationDescription(method, beanKey),
                getOperationParameters(method, beanKey),
                method.getReturnType().getName(),
                MBeanOperationInfo.UNKNOWN);
    }

}