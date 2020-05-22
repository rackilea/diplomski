public class AdapterInvocationHandler implements InvocationHandler {

    private Object target;
    private Class<?> targetClass;

    public AdapterInvocationHandler(Object target) {
        this.target = target;
        targetClass = target.getClass();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Method targetMethod = targetClass.getMethod(method.getName(), method.getParameterTypes());
            if (!method.getReturnType().isAssignableFrom(targetMethod.getReturnType()))
                throw new UnsupportedOperationException("Target (" + target.getClass().getName() + ") does not support: " + method.toGenericString());
            return targetMethod.invoke(target, args);
        } catch (NoSuchMethodException ex) {
            throw new UnsupportedOperationException("Target (" + target.getClass().getName() + ") does not support: " + method.toGenericString());
        } catch (IllegalAccessException ex) {
            throw new UnsupportedOperationException("Target (" + target.getClass().getName() + ") does not declare method to be public: " + method.toGenericString());
        } catch (InvocationTargetException ex) {
            // May throw a NullPointerException if there is no target exception
            throw ex.getTargetException();
        }
    }
}