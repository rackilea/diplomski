public static EJBObject getRemote(String url, String jndiname, Class homeClass, AppserverTyp typ) throws Exception
    {
      Object obj = getWLSContext(url).lookup(jndiname);
      EJBHome home = (EJBHome) javax.rmi.PortableRemoteObject.narrow(obj, homeClass);

      Class homeBase = home.getClass();
      Method m = homeBase.getMethod("create", (Class[])null);
      EJBObject remote = (EJBObject) m.invoke(home, (Object[])null);
      return remote;
   }