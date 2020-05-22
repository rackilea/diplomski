List<String> list = new ArrayList<String>();
list.add("abc");
list.add(null);
list.add("def");
list.removeAll(Collections.singletonList(null));
System.out.println(list);  //[abc, def]