for (int i = 0; i < arraylist1.size(); i++) {
  List<String> list1 = arraylist1.get(i);
  List<String> list2 = arraylist2.get(i);

  // Check if the two lists have any elements in common
  for (String s1 : list1) {
    if (list2.contains(s1)) {
      counter++;
    }
  }
}