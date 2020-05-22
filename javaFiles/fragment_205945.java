List<String> list1 = new ArrayList<String>();
list1.add("ant");
List<String> list2 = new ArrayList<String>();
list2.add("apple");
list2.add("bear");
//comparing 'a' from "ant" from list1 with 'a' from "apple" from list2
System.out.println(list1.get(0).charAt(0) == list2.get(0).charAt(0)); //true
//comparing 'a' from "ant" from list1 with 'b' from "bear" from list2
System.out.println(list1.get(0).charAt(0) == list2.get(1).charAt(0)); //false