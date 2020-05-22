public static Collection<Integer> sort(Collection<Integer> l1){
    List<Integer> sortedList = new ArrayList<Integer>();
    for (Iterator<Integer> it = l1.iterator(); it.hasNext(); ) {
        Integer currentValue = it.next();

        // Look into sortedList the position where currentValue should go into
        int pos = 0;
        for (int i=0;i<sortedList.size();i++) { 
             // Compare currentValue with sortedList.get(i) 
             // to know if i is the right position for currentValue. 
             // If it is, assign it to pos
         }
         sortedList.add(pos, currentValue);
     }
     return sortedList;
}