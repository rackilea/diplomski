BasicDBObject change = new BasicDBObject("pseudo", "gPlayer");   
BasicDBObject setDoc = new BasicDBObject();                 
setDoc.append("status", "0"); 
setDoc.append("pos.0.X", "0");                                        
setDoc.append("pos.1.Y", "0");                                      
setDoc.append("pos.2.Z", "0");                                          
BasicDBObject account = new BasicDBObject("$set", setDoc);
coll.update(change, account);