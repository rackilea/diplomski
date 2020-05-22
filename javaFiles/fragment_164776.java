MyObject myObj = getMyObjectThroughSomeOneToManyRelation(idOne, idOther); 
// till now was null 
myObj.setSomeDateAttr(someDate); 
//You can use myObj as well instead myNewObj
MyObject myNewObj= genericDao.update(myObj);  
 //No need to call get
//MyObject myObjFromDB = genericDao.getById(myObj.getId(), MyObject.class); 
System.out.println("Updated value:"+myNewObj.getSomeDateAttr());