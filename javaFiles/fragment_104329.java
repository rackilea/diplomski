//new Iterator Instance will always have a next item
//Iterator is a different instance during each iteration
while(myList.iterator().hasNext()) { 
    System.out.println(myList.iterator().next());
}
System.out.println();