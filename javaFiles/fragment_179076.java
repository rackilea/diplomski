public K next() throws NoSuchElementException{
  int tempStore = -1;
  MapHashCellList tempCells = null;
  System.out.println("Got here! 1");
  System.out.println(mapCells);
  if(mapCells.length==0) {throw new NoSuchElementException();}
  if (mapCells[arrayPointer]!=null && listCounter<=mapCells[arrayPointer].size()-2){
          System.out.println("Got here! 2");
    tempCells = mapCells[arrayPointer];
    tempStore = listCounter;
    listCounter++;
  }
  else{
    arrayPointer++;
          System.out.println("Got here! 3");
    while (mapCells[arrayPointer]==null){
      arrayPointer++;
      listCounter=0;
            System.out.println("Got here! 4");
      if(mapCells[arrayPointer]!=null){
        tempCells = mapCells[arrayPointer];
        tempStore = listCounter;
        listCounter++;
      }
      System.out.println("ListCounter: " + listCounter);
      System.out.println("Array: " + arrayPointer);
    }
  }
  return (K)tempCells.get(tempStore).getKey();
}