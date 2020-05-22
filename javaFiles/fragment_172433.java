Iterator<String> it = names.iterator(); 
while(it.hasNext()) { 
  System.out.println(names); 
  String buttonName = it.next(); 
  JButton b = buttonCache.get(buttonName); 
  it.remove(); 
} 
System.out.println(names);