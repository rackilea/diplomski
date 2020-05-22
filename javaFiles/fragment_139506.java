for (int i=0; i<listToReorder.size(); i++){
  String item = listToReorder.get(i);

//NOTE: '==true' isn't required if the method returns a boolean
  if(checkIfWordIsInTextFile(item)){ 
//As per  @rishi007bansod suggestion: If we remove an item, then the next item will be shifted into this index & effectively skipped.  Therefore we want the index not to change this time around so decrement i after usage
    listToReorder.remove(i--);
    listToReorder.add(item);
  }
}