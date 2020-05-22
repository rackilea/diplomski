List<Entry<String, Integer>> myList = new ArrayList<...>();
 for (Entry<String, Integer> e : myMap.entrySet())
       myList.add(e);

 Collections.sort(myList, new Comparator<Entry<String, Integer>>(){

    int compare(Entry a, Entry b){
       // compare b to a to get reverse order
       return new Integer(b.getValue()).compareTo(new Integer(a.getValue());
    }
 });

 List<Entry<String, Integer>> top5 = myList.sublist(0, 5);