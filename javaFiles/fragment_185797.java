@Status
@Provider
public class StatusFilter implements ContainerResponseFilter {

    @Context
    private ResourceInfo info;

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
        Status status = getInterfaceAnnotation(info.getResourceMethod());
        if (status != null) {
            int code = status.code();
            if (code != Status.DEFAULT_CODE && res.getStatus() == 200) {
                res.setStatus(code);
            }
        }
    }

    private static Status getInterfaceAnnotation(Method resourceMethod) {
        String methodName = resourceMethod.getName();
        Class<?>[] paramTypes = resourceMethod.getParameterTypes();
        Class<?> iface = resourceMethod.getDeclaringClass().getInterfaces()[0];
        Method ifaceMethod;
        try {
            ifaceMethod = iface.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
        return ifaceMethod.getAnnotation(Status.class);
    }
}