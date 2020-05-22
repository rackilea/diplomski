PersistenceManager pm = getPersistenceManager();
try {
    q = pm.newQuery(MyObject.class, query);
    List<MyObject> objects = (List<MyObject>) q.execute();
    pm.currentTransaction().begin(); // <-------
    for (MyObject object: objects) {
        object.setMyField(newValue);
    }
    pm.currentTransaction().commit(); // <-------
    System.out.println(objects); //[1]
} finally {
    pm.close();
}