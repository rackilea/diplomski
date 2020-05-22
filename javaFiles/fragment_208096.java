DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
Entity item = new Entity("Item");
datastore.put(item);        

Entity user = new Entity("User");
List<Key> items = new ArrayList<Key>();
items.add(item.getKey());
user.setProperty("ItemsList", items);
datastore.put(user);