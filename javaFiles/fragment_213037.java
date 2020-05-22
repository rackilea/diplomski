final Link found = theLinkedList.find(name);
if (found == null){
    System.out.println("Not Found");
} else {
    System.out.println(found.Name + " was found.");
}
System.out.println();
theLinkedList.display();