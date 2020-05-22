ArrayList<String> list = new ArrayList<String>();
list.add("name1");
list.add("name2");
list.add("name3");
list.add("name4");
list.add("name5");
list.add("name6");

String newList = list.toString();                
List<String> myList = Arrays.asList(newList.substring(1, newList.length() - 1).replaceAll("\\s", "").split(","));

System.out.println(myList);