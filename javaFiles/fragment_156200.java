public static Class<? extends Remote> toRemoteInterface(Class<?> inter) throws Exception {
    return cache("toRemote", inter, () -> uncheck(() -> {
      ClassPool pool = ClassPool.getDefault();
      CtClass cc = pool.getAndRename(inter.getName(), inter.getName() + "$RemoteVersion");
      cc.setModifiers(Modifier.PUBLIC | cc.getModifiers());
      cc.addInterface(pool.get(Remote.class.getName()));
      for (CtMethod cm : cc.getMethods()) {
        cm.setExceptionTypes(new CtClass[] { pool.getCtClass(RemoteException.class.getName()) });
      }
      cc.writeFile();
      return cc.toClass();
    }));
  }