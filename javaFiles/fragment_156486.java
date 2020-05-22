HashMap<Integer,SomeClass> someMap = new HashMap<Integer,SomeClass>();

 someMap.put(0, someClassObject1);
 someMap.put(10, someClassObject2);

 someMap.get(0); // will return someClassObject1
 someMap.get(3); // will return null
 someMap.get(10); // will return someClassObject2