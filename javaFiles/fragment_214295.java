DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
JSONArray abc;
Iterator iter = abc.iterator();
while (iter.hasNext()) {
   innerObj = (JSONObject) iter.next();
   // create
   Key abckey = KeyFactory.createKey("aaa",Long.parseLong(innerObj.get(                                                                    
                    "id").toString()));
   Entity abcentity = new Entity(abckey);

   // fill with data
   // ...
   // abcentity.setProperty ...
   //

   // save
   ds.put(abcentity);
}