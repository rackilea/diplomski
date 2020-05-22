List myList = new ArrayList();
myList.add("superman");
myList.add("antman");
myList.add("ACTION");
myList.add(123);
myList.add("batman");

System.out.println(myList);
if (myList.contains("batman")) {
    System.out.println("found it!");
} else {
    System.out.println("************************* Did not find anything!!1");
}