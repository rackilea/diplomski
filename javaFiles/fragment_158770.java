class UnwrapAndReadDbObjectCallback<T> extends MongoTemplate.ReadDbObjectCallback<T> {
    public UnwrapAndReadDbObjectCallback(EntityReader<? super T, DBObject> this$0, Class<T> reader, String type) {
        super(reader, type, collectionName);
    }

    public T doWith(DBObject object) {
        Object idField = object.get("_id");
        if (!(idField instanceof DBObject)) {
            return super.doWith(object);
        } else {
            DBObject toMap = new BasicDBObject();
            DBObject nested = (DBObject)idField;
            toMap.putAll(nested);
            Iterator var5 = object.keySet().iterator();

            while(var5.hasNext()) {
                String key = (String)var5.next();
                if (!"_id".equals(key)) {
                    toMap.put(key, object.get(key));
                }
            }

            return super.doWith(toMap);
        }
    }
}