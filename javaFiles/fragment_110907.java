List<String> types = new ArrayList<String>();
types.add("abc");
types.add("def");

XStream xstream = new XStream();
xstream.alias("types", List.class);
xstream.alias("type", String.class);
System.out.println(xstream.toXML(types));