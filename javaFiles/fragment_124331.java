ArrayList<String> list = new ArrayList<>();
list.add("foo");
ArrayList<Object> list2 = (ArrayList<Object>)(Object)list;
list2.add(Integer.valueOf(10));
System.out.println(list2.get(0));
System.out.println(list2.get(1));