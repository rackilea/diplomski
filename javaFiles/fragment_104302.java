ObjectsInGroupRealm object = realm.where(ObjectsInGroupRealm.class)
    .equalTo("name", name)
    .equalTo("groupName", groupName)
    .findFirst();
 if(object == null){
     //add new object
 } else {
     //handle object already existing
 }