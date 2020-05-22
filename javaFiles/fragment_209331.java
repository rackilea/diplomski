ArrayList<String> lst = new ArrayList<String>();
lst.add("obj1");
lst.add("obj2");
lst.add("obj3");

for (int i = 0; i < lst.size(); i++) {
     String str = lst.get(i);
     lst.remove(str); //list size decrease, 
     //so when you remove an object with index 0, your new list has obj2(at index 0) and obj3(at index 1) 
     //when i is increased, it will escape obj2, it never check it or access it.
     //i--; //open to give a try
}

for (int i = 0; i < lst.size(); i++) {
    System.out.println(lst.get(i)); //will print obj2
}