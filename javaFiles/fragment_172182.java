@SuppressWarnings({"unchecked"})
public static <T> T getTargetObject(Object proxy, Class<T> targetClass) {
  if (AopUtils.isJdkDynamicProxy(proxy)) {
    try {
        return (T) ((Advised)proxy).getTargetSource().getTarget();
    } catch (Exception e) {
        return null;
    }
  } else {
    return (T) proxy;
  }
}