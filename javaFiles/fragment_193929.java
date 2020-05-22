public void aMethod(int i, int j){

    // N won't work here. Is myArray.length the best alternative       
    if(i < 0 || i >= myArray.length ) 
      throw new IndexOutOfBoundsException("Index i out of bounds");
    if(j < 0 || j >= myArray[i].length) 
      throw new IndexOutOfBoundsException("Column index j out of bounds");            
}