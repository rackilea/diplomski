TreeSet<Entry<String, Integer>> myTree = new TreeSet<...>(
    new  Comparator<Entry<String, Integer>>(){

      int compare(Entry a, Entry b){
         // compare b to a to get reverse order
         return new Integer(b.getValue()).compareTo(new Integer(a.getValue());
      }
    });
 for (Entry<String, Integer> e : myMap.entrySet())
       myList.add(e);

 List<Entry<String, Integer>> top5 = new ArrayList<>();
 int i=0;
 for (Entry<String, Integer> e : myTree) {
     top5.add(e);
     if (i++ == 4) break;
 }