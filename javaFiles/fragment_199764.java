Map json = (Map)parser.parse(jsonText, containerFactory);
Iterator iter = json.entrySet().iterator();
System.out.println("==iterate result==");
while(iter.hasNext()){
  Map.Entry entry = (Map.Entry)iter.next();
  System.out.println(entry.getKey() + "=>" + entry.getValue());
}

System.out.println("==toJSONString()==");
System.out.println(JSONValue.toJSONString(json));