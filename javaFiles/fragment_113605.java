List<Integer> oldList = ...
/* Specify the size of the list up front to prevent resizing. */
List<String> newList = new ArrayList<String>(oldList.size()) 
for (Integer myInt : oldList) { 
  newList.add(String.valueOf(myInt)); 
}