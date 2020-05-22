public void removePairedElements(ArrayList<Integer> a){

    Collections.sort(a); //Sort a

    int i = 0;
    while(i < a.size() - 1){
      //Check if i and i+1 are the same element. If so, remove both
      if(a.get(i).equals(a.get(i+1))){
        //Remove i twice - effectively removes i and i+1
        a.remove(i);
        a.remove(i);

        //Move i *back* one index, which is equivalent to 
        //moving forward one because we just removed two elements.
        //Prevent i from becoming negative though.
        i = Math.max(0, (i - 1));
      }
      else{
        i++;
      }
    }
}