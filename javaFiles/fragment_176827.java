class TestUtils {

  ...

public static Object unwrapService(Object service) throws Exception {
  final boolean aopProxy = AopUtils.isAopProxy(service);
  final boolean instanceCheck = service instanceof Advised;
  if (aopProxy && instanceCheck) {
    Object target = ((Advised) service).getTargetSource().getTarget();
    return target;
  }
return null;
}
}