Iterator it = hashmap.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry keys = (Map.Entry)it.next();
    if(keys.getKey().equals(your_user_input)) {
             //throw exception, logs, or print your error msg.
     }
    it.remove(); //ConcurrentModificationException 
}