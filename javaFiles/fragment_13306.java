PersistenceInterface store = new AmazonSdbHelper();
store.setDomain("domain");
store.query("SELECT * FROM domain");
while (store.hasNext()) {
    String key = store.next();
    String address = store.getAttributeAsString("address");
    Collection<String> phones = store.getAttributeAsCollection("phones");
    int visits = store.getAttributeAsInt("visits");
}