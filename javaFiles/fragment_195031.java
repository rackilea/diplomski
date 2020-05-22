class RemoteObjectCache {

  private static WeakHashMap<ObjID, WeakReference<IdentifieableRemoteObject>> cache = new WeakHashMap<>;

  public static void register(IdentiefieableRemoteObject iro) {
    cache.put(iro.getID(), iro);
  }

  public IdentifieableRemoteObject lookUp(ObjID id) {
    chache.get(id);
  }

}