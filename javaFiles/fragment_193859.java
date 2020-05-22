/**
 * Checks if the given object is a proxy, and unwraps it if it is.
 *
 * @param bean The object to check
 * @return The unwrapped object that was proxied, else the object
 * @throws Exception
 */
public final Object unwrapProxy(Object bean) throws Exception {
    if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {
        Advised advised = (Advised) bean;
        bean = advised.getTargetSource().getTarget();
    }
    return bean;
}