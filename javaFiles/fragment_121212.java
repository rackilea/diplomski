List<Integer> sums = ArrayList<Integer>();

for (List<RrdData> counterEntry : myData.getValues()) {
   for (int i = 0; i<counterEntry.size(); i++) {
        if(sums.size > i){
            sums.get(i) += counterEntry.getValue(i);
         }else 
            sums.add(counterEntry.getValue(i);
    } 
}