LinkedList list = new LinkedList(); 
list.add("foo"); 
list.add(new Integer(100)); 
list.add(new Double(1000.21)); 
list.add(new Boolean(true)); 
list.add(null); 
String jsonText = JSONValue.toJSONString(list); 
System.out.print(jsonText);