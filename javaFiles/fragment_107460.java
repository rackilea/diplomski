// print the list
  System.out.println("LinkedList:" + myList);

  // create an array and copy the list to it
  Object[] array = myList.toArray();

  // print the array
  for (int i = 0; i < myList.size(); i++) {
     System.out.println("Array:" + array[i]);
  }