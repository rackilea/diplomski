public static <E extends RealmObject> List<Pojo<E>> fromRealmList(
    RealmList<E> realmList, Class<Pojo<E>> clazz) {

   List<Pojo<E>> pojoObjects = new ArrayList<>();
   ...
   Pojo<E> newInstance = clazz.getConstructor(...).newInstance(...).fromRealm(...);
   pojoObjects.add(newInstance);
   ...
}