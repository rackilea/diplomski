// all the keys of an entity are appended and than compared with other entity
int compare(Entity e1, Entity e2){
  return appendAndHandleNull(e1.key1, e1.key2, e1.key3).compareTo(appendAndHandleNull(e2.key1, e2.key2, e2.key3));
}



/** 
 * method to get all keys of an entity in appended form
 */
private static final String appendAndHandleNull(String list...){
   StringBuilder result = new StringBuilder ();
   for(String s : list){
      result.append(s!=null?s:"").append(" ");//note: a space is appended after each key
   }
   return result.toString();
}