LinkedList lList = new LinkedList();
lList.add("1");
lList.add("2");
lList.add("3");
lList.add("4");
lList.add("5");
//lList look like [1,2,3,4,5]
ListIterator itr = lList.listIterator(); //create iterator at position before element 0

itr.next() // return the next element => so return "1"
           // And advance the cursor position => position between element 0 and element 1

itr.previous(); // return the previous element => so return "1"
           // And step back the cursor position => position before element 0