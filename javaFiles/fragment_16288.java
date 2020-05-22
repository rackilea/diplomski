public class MyMap extends java.util.HashMap{
 @Override
 public void putAll(java.util.Map mapToAdd){
      java.util.Iterator iterKeys = keySet().iterator();
      while(iterKeys.hasNext()){
           String currentKey = (String)iterKeys.next();
           if(mapToAdd.containsKey(currentKey)){
                mapToAdd.put(currentKey, new Integer(Integer.parseInt(get(currentKey).toString()) + Integer.parseInt(mapToAdd.get(currentKey).toString())));
           }else{
                mapToAdd.put(currentKey, get(currentKey));
           }
      }
      super.putAll(mapToAdd);
 }
 public static void main(String args[]){
     MyMap m1 = new MyMap();
     m1.put("One", new Integer(1));
     m1.put("Two", new Integer(2));
     m1.put("Three", new Integer(3));
     MyMap m2 = new MyMap();
     m2.put("One", new Integer(4));
     m2.put("Two", new Integer(5));
     m2.put("Three", new Integer(6));
     m1.putAll(m2);
     System.out.println(m1);
 }