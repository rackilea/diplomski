for (int i = 0; i<longestLength;i++){
   for (List<RrdData> counterEntry : myData.getValues()) {
       if(counterEntry.size() > i){
           sum += counterEntry.getValue(i);
      }

   }
   System.out.println(sum);
   sum = 0;
}