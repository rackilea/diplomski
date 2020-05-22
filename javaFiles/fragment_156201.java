public static <T> T fromRemote(Remote remote, Class<T> inter) throws Exception {
    Enhancer e = new Enhancer();
    e.setInterfaces(new Class[] { inter });
    e.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
      Method remoteMethod = remote.getClass().getMethod(method.getName(), method.getParameterTypes());
      try {
        return remoteMethod.invoke(remote, args);
      } catch (InvocationTargetException ex) {
        Throwable targetException = ex.getTargetException();
        while (targetException instanceof RemoteException) {
          targetException = targetException.getCause();
        }
        throw targetException;
      }
    });
    return (T) e.create();
  }

  public static <T> Remote toRemote(T local, Class<T> inter) throws Exception {
    Enhancer e = new Enhancer();
    e.setSuperclass(UnicastRemoteObject.class);
    e.setInterfaces(new Class[] { toRemoteInterface(inter) });
    e.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
      Method targetMethod = local.getClass().getMethod(method.getName(), method.getParameterTypes());
      try {
        return targetMethod.invoke(local, args);
      } catch (InvocationTargetException ex) {
        Throwable targetException = ex.getTargetException();
        throw new RemoteException(targetException.getMessage(), targetException);
      }
    });
    return (Remote) e.create();
  }